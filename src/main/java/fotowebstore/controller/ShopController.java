package fotowebstore.controller;

import fotowebstore.dao.AlbumDao;
import fotowebstore.dao.PhotoDao;
import fotowebstore.entities.Album;
import fotowebstore.entities.Photo;
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

    @Autowired
    public ShopController(HttpSession session, AlbumDao albumDao, PhotoDao photoDao) {
        this.session = session;
        this.albumDao = albumDao;
        this.photoDao = photoDao;
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
}
