package fotowebstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * Created by marouano on 3/27/17.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView submit(@RequestParam("username") String username, @RequestParam("password") String password) {
        return new ModelAndView("overview");

    }
}
