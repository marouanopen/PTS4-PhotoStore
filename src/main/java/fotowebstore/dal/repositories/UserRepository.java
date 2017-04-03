package fotowebstore.dal.repositories;

import fotowebstore.dal.interfaces.IUserServices;
import fotowebstore.models.User;

import java.util.ArrayList;

public class UserRepository {
    private IUserServices userServices;

    public UserRepository(IUserServices userServices) {
        this.userServices = userServices;
    }

    public User get(int id) {
        return null;
    }

    public ArrayList<User> list() {
        return null;
    }
}
