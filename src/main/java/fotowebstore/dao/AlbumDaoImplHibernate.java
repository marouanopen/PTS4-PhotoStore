package fotowebstore.dao;

import fotowebstore.entities.Album;
import fotowebstore.entities.User;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class AlbumDaoImplHibernate extends BaseDao implements AlbumDao {

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

    public Album find(int id) {
        Query query = manager.createQuery("select a from Album as a where a.ID = :id");
        query.setParameter("id", id);
        return (Album) query.getSingleResult();
    }

    public Album findByVoucherCode(String voucherCode) {
        Query query = manager.createQuery("select a from Album as a where a.voucherCode = :voucherCode");
        query.setParameter("voucherCode", voucherCode);
        return (Album) query.getSingleResult();
    }

    public void linkUserAndAlbum(User user, Album album) {
        Query query =
                manager.createNativeQuery("INSERT INTO `user_album`(`user_id`, `album_id`) VALUES (:userid,:albumid)");
        query.setParameter("userid", user.getID());
        query.setParameter("albumid", album.getID());
        query.executeUpdate();
    }

    public List<Album> findAll() {
        CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Album.class));
        return manager.createQuery(cq).getResultList();
    }
}
