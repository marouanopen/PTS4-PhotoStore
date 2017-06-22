package fotowebstore.entities;

import javax.persistence.*;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected boolean hidden;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        album.getPhotos().remove(this);
        this.album = album;
        album.getPhotos().add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public int hashCode() {
        return id +
                name.hashCode() +
                (int) price +
                album.hashCode();
    }
}
