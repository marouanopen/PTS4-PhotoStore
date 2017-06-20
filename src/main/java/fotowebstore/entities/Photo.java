package fotowebstore.entities;

import javax.persistence.*;

@Entity
public class Photo extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private boolean hidden;
    @ManyToOne
    @JoinColumn(name = "AlbumID")
    private Album album;

    public Photo() {
    }

    public Photo(String name) {
        this.name = name;
    }

    public Photo(String name, double price) {
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        album.getPhotos().remove(this);
        this.album = album;
        album.getPhotos().add(this);
    }

    @Override
    public int hashCode() {
        return id +
                name.hashCode() +
                (int) price +
                album.hashCode();
    }
}
