package fotowebstore.dao;

import fotowebstore.entities.Photo;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class PhotoDaoImplHibernate extends BaseDao implements PhotoDao {

    public Photo create(Photo photo) {
        try {
            manager.persist(photo);
        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            return null;
        }

        return photo;
    }

    public Photo update(Photo photo) {
        try {
            return manager.merge(photo);
        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean delete(Photo photo) {
        try {
            manager.remove(photo);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Photo find(int id) {
        Query query = manager.createQuery("select p from Photo as p where p.id = :id");
        query.setParameter("id", id);
        return (Photo) query.getSingleResult();
    }

    public List<Photo> findAll() {
        CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Photo.class));
        return manager.createQuery(cq).getResultList();
    }
}
