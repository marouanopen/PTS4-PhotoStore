package fotowebstore.controller;

import fotowebstore.dao.UserDao;
import fotowebstore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.core.MultivaluedMap;
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

    @PostMapping("/requests")
    public ModelAndView requestSubmit(@RequestBody List<User> users){


        //System.out.println(users);
        List<User> photographerRequests = userDao.findPhotographerRequests();
        return new ModelAndView("WEB-INF/requests", "users", photographerRequests);
    }

    @RequestMapping("/overview")
    public ModelAndView overview(){

        List<User> photographers = userDao.findAll();
        return new ModelAndView("WEB-INF/overview", "photographers", photographers);
    }
}
