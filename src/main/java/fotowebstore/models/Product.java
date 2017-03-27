package fotowebstore.models;

import java.util.ArrayList;

/**
 * Created by Arjan on 26-3-2017.
 */
public class Product {
    private int id;
    private ArrayList<Photo> photos;

    public Product(int id, ArrayList<Photo> photos) {
        this.id = id;
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "ID = " + id;
    }
}
