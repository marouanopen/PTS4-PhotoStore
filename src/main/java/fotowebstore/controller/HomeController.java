package fotowebstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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

    @RequestMapping("/test")
    public ModelAndView test() {
        ArrayList<String> jemoeder = new ArrayList<String>();
        String test = (String) session.getAttribute("Test");
        jemoeder.add(test);
        return new ModelAndView("WEB-INF/test", "jemoeder", jemoeder);
    }
}
