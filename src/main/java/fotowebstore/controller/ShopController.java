package fotowebstore.controller;

import fotowebstore.dao.AlbumDao;
import fotowebstore.dao.PhotoDao;
import fotowebstore.dao.UserDao;
import fotowebstore.entities.Album;
import fotowebstore.entities.Photo;
import fotowebstore.entities.User;
import fotowebstore.util.EmailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {

    private HttpSession session;
    private AlbumDao albumDao;
    private PhotoDao photoDao;
    private UserDao userDao;

    @Autowired
    public ShopController(HttpSession session, AlbumDao albumDao, PhotoDao photoDao, UserDao userDao) {
        this.session = session;
        this.albumDao = albumDao;
        this.photoDao = photoDao;
        this.userDao = userDao;
    }

    @PostMapping("/addToShoppingCart")
    public ModelAndView addToShoppingCart(@RequestParam("productId") int productId, @RequestParam("type") String type) {
        Object product = null;
        ModelAndView modelAndView = null;

        if (type.equals("photo")) {
            product = photoDao.find(productId);
            Photo photo = (Photo) product;
            modelAndView = new ModelAndView("WEB-INF/photooverview", "album", photo.getAlbum());
        } else if (type.equals("album")) {
            product = albumDao.find(productId);
            Album album = (Album) product;
            modelAndView = new ModelAndView("redirect:/albumoverview");
        }

        if (session.getAttribute("shoppingCart") != null) {
            List<Object> products = (List<Object>) session.getAttribute("shoppingCart");
            products.add(product);
        } else {
            List<Object> products = new ArrayList<Object>();
            products.add(product);
            session.setAttribute("shoppingCart", products);
        }

        return modelAndView;
    }

    @RequestMapping("/cart/remove/{id}/{type}")
    public ModelAndView removeFromCart(@PathVariable("id") int id,
                                       @PathVariable("type") String type) {
        List<Object> products = (List<Object>) session.getAttribute("shoppingCart");

        if (type.equals("Album")) {
            for (Object product : products) {
                if (product instanceof Album && ((Album) product).getId() == id) {
                    products.remove(product);
                    break;
                }
            }
        } else if (type.equals("Photo")) {
            for (Object product : products) {
                if (product instanceof Photo && ((Photo) product).getId() == id) {
                    products.remove(product);
                    break;
                }
            }
        }

        return new ModelAndView("redirect:/cart");
    }

    @PostMapping("/pay")
    public ModelAndView payShoppingCart() {
        List<Object> products = (List<Object>) session.getAttribute("shoppingCart");

        for (Object product : products) {
            if (product instanceof Album) {
                Album album = (Album) product;
                User owner = userDao.findById(album.getUser().getID());

                for (Photo photo : album.getPhotos())
                    owner.setBalance(owner.getBalance() + photo.getPrice());

                userDao.update(owner);
            } else if (product instanceof Photo) {
                Photo photo = (Photo) product;
                User owner = userDao.findById(photo.getAlbum().getUser().getID());

                owner.setBalance(owner.getBalance() + photo.getPrice());
                userDao.update(owner);
            }
        }

        sendPaymentInfo();

        session.removeAttribute("shoppingCart");

        return new ModelAndView("redirect:/albumoverview");
    }

    private void sendPaymentInfo() {
        User user = (User) session.getAttribute("userData");

        String lineSeparator = System.getProperty("line.separator");

        String purchaseList = "";

        List<Object> products = (List<Object>) session.getAttribute("shoppingCart");

        for (Object product : products) {
            if (product instanceof Album) {
                Album album = (Album) product;
                purchaseList += lineSeparator + "An album: " + lineSeparator;

                for (Photo photo : album.getPhotos()) {
                    photo.setName(photo.getName().replace("_", " ").replace(".jpg", ""));
                    purchaseList += "   -" + photo.getName() + " -> $" + photo.getPrice() + lineSeparator;
                }
            } else if (product instanceof Photo) {
                Photo photo = (Photo) product;
                photo.setName(photo.getName().replace("_", " ").replace(".jpg", ""));

                purchaseList += lineSeparator + "A single photo: " + photo.getName() + " -> $" + photo.getPrice() +
                        lineSeparator;
            }
        }

        EmailHandler.send(user.getEmail(), "Your recent purchase",
                "You recently purchased some items on the site!" +
                        lineSeparator +
                        "Here is a list of items you purchased:" +
                        lineSeparator +
                        purchaseList +
                        "Your total is: $" + getTotalPrice(products));
    }

    private double getTotalPrice(List<Object> products) {
        double totalPrice = 0;

        for (Object product : products) {
            if (product instanceof Album) {
                Album album = (Album) product;
                totalPrice += album.getPrice();
            } else if (product instanceof Photo) {
                Photo photo = (Photo) product;
                totalPrice += photo.getPrice();
            }
        }

        return totalPrice;
    }
}
