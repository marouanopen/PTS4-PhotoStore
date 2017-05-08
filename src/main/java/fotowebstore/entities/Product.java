package fotowebstore.entities;

import java.util.ArrayList;

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
