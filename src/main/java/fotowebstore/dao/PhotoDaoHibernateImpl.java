package fotowebstore.dao;

import fotowebstore.entities.Photo;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class PhotoDaoHibernateImpl implements PhotoDao {

    @PersistenceContext
    private EntityManager manager;

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

    public List<Photo> findAll() {
        CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Photo.class));
        return manager.createQuery(cq).getResultList();
    }
}
