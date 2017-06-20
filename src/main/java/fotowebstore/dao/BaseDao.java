package fotowebstore.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public abstract class BaseDao {

    @PersistenceContext
    protected EntityManager manager;

    public void save() {
        manager.flush();
    }
}
