package fotowebstore.dao;

import fotowebstore.entities.User;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDaoImplHibernate extends BaseDao implements UserDao {

    public boolean create(User user) {
        try {
            manager.persist(user);
            return true;
        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(User user) {
        try {
            manager.merge(user);
            return true;
        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean remove(User user) {
        try {
            manager.remove(findById(user.getID()));
            return true;
        } catch (Exception ex) { //Don't know what exception will be thrown here.
            ex.printStackTrace();
            return false;
        }
    }

    public User findByEmail(String email) {
        Query query = manager.createNamedQuery("User.findByEmail", User.class);
        query.setParameter("email", email);

        try {
            return (User) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println(email + " not found.");
            return null;
        }
    }

    public User findById(int Id) {
        Query query = manager.createNamedQuery("User.findById", User.class);
        query.setParameter("id", Id);

        try {
            return (User) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println(Id + " not found.");
            return null;
        }
    }

    /*public User findByEmailAndHash(String email, String hash) {
        Query query = manager.createNamedQuery("User.findByEmailAndHash", User.class);
        query.setParameter("email", email);
        query.setParameter("hash", hash);
        return (User) query.getSingleResult();
    }*/

    public List<User> findAll() {
        CriteriaQuery cq = manager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(User.class));
        return manager.createQuery(cq).getResultList();
    }

    public List<User> findPhotographerRequests(){
        Query query = manager.createNativeQuery("select * from user where requesting = 1", User.class);
        return query.getResultList();
    }
}
