package fotowebstore.dal.interfaces;

import fotowebstore.models.User;

import java.util.ArrayList;

public interface IUserServices {
    User get(int id);

    ArrayList<User> list();
}
