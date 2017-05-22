package fotowebstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;

@Entity
public class Photo {

    @Id
    private int id;
    private String name;
    private double price;
    private File path;
    private boolean hidden;

    public Photo() {
    }

    public Photo(String name, double price, File path) {
        this.name = name;
        this.price = price;
        this.path = path;
    }

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

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(File path) {
        this.path = path;
    }
}
