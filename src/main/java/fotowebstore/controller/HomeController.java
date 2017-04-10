package fotowebstore.controller;

import fotowebstore.models.SerialKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping("/test")
    public ModelAndView test() {
        ArrayList<String> jemoeder = new ArrayList<String>();
        jemoeder.add(SerialKey.generate());
        jemoeder.add(SerialKey.generate());
        jemoeder.add(SerialKey.generate());
        return new ModelAndView("test", "jemoeder", jemoeder);
    }
}
