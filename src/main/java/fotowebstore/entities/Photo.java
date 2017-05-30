package fotowebstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Photo {

    @Id
    private int id;
    private String name;
    private double price;
    private boolean hidden;

    public Photo() {
    }

    public Photo(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Photo(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
}
