package fotowebstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findByEmail", query = "select u from user as u where u.email = :email"),
        @NamedQuery(name = "User.findById", query = "select u from user as u where u.ID = :id"),
        @NamedQuery(name = "User.findByEmailandHash", query = "select u from user as u where u.email = :email and u.password = :hash")
})
public class User implements Serializable {

    @Id
    private int ID;
    private String name;
    private String street;
    private int houseNumber;
    private String zipCode;

    private String city;
    @Column(unique = true)
    private String email;
    private String password;
    private Boolean photographer;
    private Boolean blocked;
    private Boolean admin;

    private ArrayList<Product> products = new ArrayList<Product>();


    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String street, int houseNumber, String zipCode, String city, String email, String password) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.email = email;
        this.password = password;
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

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhotographer(Boolean photographer) {
        this.photographer = photographer;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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

    public int getHouseNumber() {
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

    public Boolean getPhotographer() {
        return photographer;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return name;
    }
}

