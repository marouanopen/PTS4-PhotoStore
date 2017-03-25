package fotowebstore.models;

/**
 * Created by user on 25-3-2017.
 */
public class User {
    private String name;
    private Boolean photographer;

    public User(String name) {
        this.name = name;
        this.photographer = false;
    }

    @Override
    public String toString() {
        return name;
    }
}
