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
    private Boolean photographer;
    private Boolean blocked;

    private ArrayList<Product> products;

    public User(String name, String streetAddress, int houseNumber, String zipCode, String city, String email) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.email = email;
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

    public Boolean getPhotographer() {
        return photographer;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public ArrayList<Product> getProducts() {
        return products;
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

