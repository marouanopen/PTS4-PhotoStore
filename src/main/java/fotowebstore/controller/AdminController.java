package fotowebstore.controller;

import fotowebstore.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by user on 25-3-2017.
 */
@Controller
public class AdminController {

    @RequestMapping("/overview")
    public ModelAndView overview(){
        ArrayList<User> photographers = new ArrayList<User>();
        photographers.add(new User("Persoon1"));
        photographers.add(new User("Persoon2"));
        photographers.add(new User("Persoon3"));
        photographers.add(new User("Persoon4"));
        return new ModelAndView("overview", "photographers", photographers);
    }
}
