package fotowebstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
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

    private ArrayList<Product> products;

    public void setName(String name) {
        this.name = name;
    }

    public  User() {
        photographer = false;
        blocked = false;
        admin = false;

        products = new ArrayList<Product>();
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        photographer = false;
        blocked = false;
        admin = false;

        products = new ArrayList<Product>();
    }

    public User(String name, String street, int houseNumber, String zipCode, String city, String email, String password) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.email = email;
        this.password = password;
        photographer = false;
        blocked = false;
        admin = false;

        products = new ArrayList<Product>();
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

    public String getPassword() { return password; }

    public Boolean getPhotographer() {
        return photographer;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public Boolean getAdmin() { return admin; }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return name;
    }

    public void changeBlockedStatus(){
        blocked = !blocked;
    }

    public void changePhotographerStatus(){
        photographer = !photographer;
    }

    public void addProduct(Product product){
        products.add(product);
    }
}

