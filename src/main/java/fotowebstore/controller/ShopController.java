package fotowebstore.controller;

import fotowebstore.dao.AlbumDao;
import fotowebstore.dao.PhotoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        if (type.equals("photo"))
            product = photoDao.find(productId);
        else if (type.equals("album"))
            product = albumDao.find(productId);

        if (session.getAttribute("shoppingCart") != null) {
            List<Object> products = (List<Object>) session.getAttribute("shoppingCart");
            products.add(product);
        } else {
            List<Object> products = new ArrayList<Object>();
            products.add(product);
            session.setAttribute("shoppingCart", products);
        }

        return new ModelAndView("");
    }
}
