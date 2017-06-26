package fotowebstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@NamedQueries({
        @NamedQuery(name = "User.findByEmail", query = "select u from User as u where u.email = :email"),
        @NamedQuery(name = "User.findById", query = "select u from User as u where u.ID = :id")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    //@Column(unique = true)
    private String email;
    private String password;
    private boolean photographer;
    private boolean blocked;
    private boolean admin;
    private String salt;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_album",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> voucherAlbums;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Album> ownedAlbums;

    private boolean requesting;


    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String street, String houseNumber, String zipCode, String city, String email, String password, String salt) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhotographer(boolean photographer) {
        this.photographer = photographer;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isRequesting() {
        return requesting;
    }

    public void setRequesting(boolean requesting) {
        this.requesting = requesting;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getPhotographer() {
        return photographer;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public boolean getAdmin() {
        return admin;
    }

    public boolean isPhotographer() {
        return photographer;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Set<Album> getVoucherAlbums() {
        return voucherAlbums;
    }

    public void setVoucherAlbums(Set<Album> voucherAlbums) {
        this.voucherAlbums = voucherAlbums;
    }

    public Set<Album> getOwnedAlbums() {
        return ownedAlbums;
    }

    public void setOwnedAlbums(Set<Album> ownedAlbums) {
        this.ownedAlbums = ownedAlbums;
    }

    @Override
    public String toString() {
        return name;
    }
}

