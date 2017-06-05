package fotowebstore.controller;

import fotowebstore.dao.UserDao;
import fotowebstore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private final UserDao userDao;

    @Autowired
    public AdminController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/requests")
    public ModelAndView requests(){

        List<User> photographerRequests = userDao.findPhotographerRequests();
        return new ModelAndView("WEB-INF/requests", "users", photographerRequests);
    }

    @RequestMapping("/accept/{email}")
    public String accept(@PathVariable("email") String email) {
        User user = userDao.findByEmail(email + ".com");
        return "WEB-INF/requests";
    }

    @RequestMapping("/deny/{email}")
    public String deny(@PathVariable("email") String email) {
        User user = userDao.findByEmail(email + ".com");
        userDao.denyRequest(user);
        return "WEB-INF/requests";
    }

    @RequestMapping("/overview")
    public ModelAndView overview(){

        List<User> photographers = userDao.findAll();
        return new ModelAndView("WEB-INF/overview", "photographers", photographers);
    }
}
