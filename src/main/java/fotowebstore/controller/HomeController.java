package fotowebstore.controller;

import fotowebstore.util.EmailHandler;
import fotowebstore.util.PasswordHandler;
import fotowebstore.util.SerialKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.UUID;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "WEB-INF/index";
    }

    @RequestMapping("/test")
    public ModelAndView test() {
        ArrayList<String> jemoeder = new ArrayList<String>();
        jemoeder.add(SerialKey.generate());
        jemoeder.add(SerialKey.generate());
        jemoeder.add(SerialKey.generate());
        jemoeder.add(UUID.randomUUID().toString());
        jemoeder.add(new String(PasswordHandler.salt()));
        jemoeder.add(new String(PasswordHandler.salt()));
        jemoeder.add(new String(PasswordHandler.salt()));
        jemoeder.add(new String(PasswordHandler.salt()));
        EmailHandler emailHandler = new EmailHandler();
        //emailHandler.send("", "Code for album", SerialKey.generate());
        return new ModelAndView("WEB-INF/test", "jemoeder", jemoeder);
    }
}
