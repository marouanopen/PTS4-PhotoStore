package fotowebstore.dao;

import fotowebstore.entities.User;

import java.util.List;

public interface UserDao {

    boolean create(User user);

    boolean update(User user);

    boolean remove(User user);

    /*User findByEmail(String email);

    User findById(int Id);

    User findByEmailAndHash(String email, String hash);*/

    List<User> findAll();
}
