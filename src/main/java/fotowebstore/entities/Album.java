package fotowebstore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {

    @Id
    private int ID;
    private User user;
    private String name;
    private boolean hidden;
    private String voucherCode;

    public Album() {
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
}
