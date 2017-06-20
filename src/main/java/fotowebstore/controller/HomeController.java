package fotowebstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
