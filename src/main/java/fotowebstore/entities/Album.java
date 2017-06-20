package fotowebstore.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Album extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @ManyToOne
    private User user;
    private String name;
    private boolean hidden;
    private String voucherCode;
    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
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

    public Album(User user, String name, String voucherCode) {
        this.user = user;
        this.name = name;
        this.voucherCode = voucherCode;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public int hashCode() {
        return getID() +
                user.hashCode() +
                name.hashCode() +
                voucherCode.hashCode();
    }
}
