package fotowebstore.controller;

import fotowebstore.dao.AlbumDao;
import fotowebstore.dao.PhotoDao;
import fotowebstore.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

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

    @PostMapping("addToShoppingCart")
    public ModelAndView addToShoppingCart(@RequestParam("productId") int productId, @RequestParam("type") String type) {
        Product product = null;

        if (type.equals("photo"))
            product = photoDao.find(productId);
        else if (type.equals("album"))
            product = albumDao.find(productId);

        if (session.getAttribute("shoppingCart") != null) {
            Set<Product> products = (Set<Product>) session.getAttribute("shoppingCart");
            products.add(product);
            session.setAttribute("shoppingCart", products);
        } else {
            Set<Product> products = new HashSet<Product>();
            products.add(product);
            session.setAttribute("shoppingCart", products);
        }

        return new ModelAndView("");
    }
}
