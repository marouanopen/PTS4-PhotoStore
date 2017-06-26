package fotowebstore.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
    private String name;
    private boolean hidden;
    private String voucherCode;
    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    @OrderBy
    private Set<Photo> photos;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_album",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    public Album() {
    }

    public Album(String name) {
        this.name = name;
    }

    public Album(User owner, String name, String voucherCode) {
        this.owner = owner;
        this.name = name;
        this.voucherCode = voucherCode;
        owner.getOwnedAlbums().add(this);
    }

    public User getUser() {
        return owner;
    }

    public void setUser(User user) {
        this.owner = user;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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

    public double getPrice() {
        double price = 0;
        for (Photo photo : photos)
            price += photo.getPrice();

        return price;
    }
}
