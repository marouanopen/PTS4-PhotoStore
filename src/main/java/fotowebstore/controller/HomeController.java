package fotowebstore.controller;

import fotowebstore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private HttpSession session;

    @Autowired
    public HomeController(HttpSession session) {
        this.session = session;
    }


    @RequestMapping("/")
    public String home() {
        return "WEB-INF/index";
    }

    @RequestMapping("/main")
    public ModelAndView main(HttpSession session){
        User user = (User) session.getAttribute("userData");

        return new ModelAndView("WEB-INF/main", "user", user);
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCart() {
        return "WEB-INF/shoppingCart";
    }
}
