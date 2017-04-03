package fotowebstore.models;

import java.util.ArrayList;

/**
 * Created by Arjan on 25-3-2017.
 */
public class User {
    private String name;
    private String streetAddress;
    private int houseNumber;
    private String zipCode;

    private String city;
    private String email;
    private String password;
    private Boolean photographer;
    private Boolean blocked;

    private ArrayList<Product> products;

    public void setName(String name) {
        this.name = name;
    }

    public  User() {
        photographer = false;
        blocked = false;

        products = new ArrayList<Product>();
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        photographer = false;
        blocked = false;

        products = new ArrayList<Product>();
    }

    public User(String name, String streetAddress, int houseNumber, String zipCode, String city, String email, String password) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.email = email;
        this.password = password;
        photographer = false;
        blocked = false;

        products = new ArrayList<Product>();
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
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
        if (blocked){ blocked = false; }
        else{ blocked = true; }
    }

    public void changePhotographerStatus(){
        if (photographer){ photographer = false; }
        else{ photographer = true; }
    }

    public void addProduct(Product product){
        products.add(product);
    }
}

