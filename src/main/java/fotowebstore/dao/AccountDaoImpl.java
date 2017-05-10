package fotowebstore.dao;

import fotowebstore.entities.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Repository
@Transactional
public class AccountDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Long accountNr) {
        Account account = new Account(accountNr);
        entityManager.persist(account);
    }
}
