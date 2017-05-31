package fotowebstore.dao;

import fotowebstore.entities.Album;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class AlbumDaoHibernateImpl implements AlbumDao {

    @PersistenceContext
    private EntityManager manager;

    public Album create(Album Album) {
        try {
            manager.persist(Album);
        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            return null;
        }

        return Album;
    }

    public Album update(Album Album) {
        try {
            return manager.merge(Album);
        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean delete(Album Album) {
        try {
            manager.remove(Album);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Album> findAll() {
        CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Album.class));
        return manager.createQuery(cq).getResultList();
    }
}
