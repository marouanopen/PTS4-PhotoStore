package fotowebstore.controller;

import fotowebstore.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by marouano on 3/27/17.
 */
@Controller
public class LoginController{
    private ArrayList<User> Users;
    private User userTest;


    public LoginController() {
        Users = new ArrayList<User>();
        User userTest = new User("test", "test");
        userTest.setName("123");
        Users.add(userTest);
    }

    @GetMapping("/login")
    public ModelAndView login() {



        return new ModelAndView("login", "user", new User());
    }

    @PostMapping("/login")
    public ModelAndView submit(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("login", "user", new User());
        }
        for (User u : Users) {
            if (u.getEmail().equals(user.getEmail()) ){

                return new ModelAndView("overview");
            }
        }
        return new ModelAndView("login");

    }
}
