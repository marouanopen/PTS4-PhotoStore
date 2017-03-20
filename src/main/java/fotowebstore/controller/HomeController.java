package fotowebstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/test")
    public ModelAndView test() {

        ArrayList<String> jemoeder = new ArrayList<String>();
        jemoeder.add("Wow");
        jemoeder.add("So");
        jemoeder.add("Cool");
        return new ModelAndView("test", "jemoeder", jemoeder);
    }
}
