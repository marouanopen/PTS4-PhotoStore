package fotowebstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findByEmail", query = "select u from User as u where u.email = :email"),
        @NamedQuery(name = "User.findById", query = "select u from User as u where u.ID = :id")
})
public class User implements Serializable {

    @Id
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
    //private ArrayList<Product> products = new ArrayList<Product>();


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

//    public void setProducts(ArrayList<Product> products) {
//        this.products = products;
//    }


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

//    public ArrayList<Product> getProducts() {
//        return products;
//    }
//
//    public void addProduct(Product product) {
//        products.add(product);
//    }

    @Override
    public String toString() {
        return name;
    }
}
