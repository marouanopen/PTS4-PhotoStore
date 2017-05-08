package fotowebstore.entities;

import java.io.File;

public class Photo {

    private int id;
    private String name;
    private double price;
    private File path;

    public Photo(int id, String name, double price, File path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public File getPath() {
        return path;
    }
}
