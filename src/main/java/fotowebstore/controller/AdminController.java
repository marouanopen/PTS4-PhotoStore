package fotowebstore.controller;

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
        ArrayList<String> photographers = new ArrayList<String>();
        photographers.add("Persoon1");
        photographers.add("Persoon2");
        photographers.add("Persoon3");
        photographers.add("Persoon4");
        return new ModelAndView("overview", "photographers", photographers);
    }
}
