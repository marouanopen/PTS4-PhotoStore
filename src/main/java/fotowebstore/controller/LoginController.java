package fotowebstore.controller;

import fotowebstore.dao.UserDao;
import fotowebstore.entities.User;
import fotowebstore.enums.LoginStatus;
import fotowebstore.util.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    private final UserDao userDao;

    @Autowired
    public LoginController(UserDao userDao) {

        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String login() {
        return "WEB-INF/index";
    }

    @PostMapping("/login")
    public ModelAndView loginSubmit(@RequestBody MultiValueMap<String, String> form) {
        String email = form.getFirst("email");
        String password = form.getFirst("password");
        User user = userDao.findByEmail(email);

        if (user == null)
            return new ModelAndView("WEB-INF/index", "loginStatus", LoginStatus.FAILED);

        if (user.getID() != 0) {
            try {
                String salt = user.getSalt();
                String saltedPassword = salt + password;
                String hashedPassword = new String(PasswordHandler.hash(saltedPassword.getBytes("UTF-8")));

                if (hashedPassword.equals(user.getPassword()))
                    return new ModelAndView("WEB-INF/overview", "user", user);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return new ModelAndView("WEB-INF/index", "loginStatus", LoginStatus.FAILED);
    }

    @GetMapping("/register")
    public String register() {
        return "WEB-INF/index";
    }

    @PostMapping("/register")
    public ModelAndView registerSubmit(@RequestBody MultiValueMap<String, String> form) {
        try {
            String name = form.getFirst("name");
            String email = form.getFirst("email");
            String password = form.getFirst("password");
            String zipCode = form.getFirst("zipcode");
            String houseNumber = form.getFirst("housenumber");
            String city = form.getFirst("city");
            String street = form.getFirst("street");

            String salt = new String(PasswordHandler.salt());
            String saltedPassword = salt + password;
            String hashedPassword = new String(PasswordHandler.hash(saltedPassword.getBytes("UTF-8")));

            User user = new User(name, street, houseNumber, zipCode, city, email, hashedPassword, salt);
            userDao.create(user);

            return new ModelAndView("WEB-INF/overview", "user", user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) { //Check which exception is being thrown here.
            e.printStackTrace();
            return new ModelAndView("WEB-INF/index", "loginStatus", LoginStatus.DUPLICATE_EMAIL);
        }

        return new ModelAndView("WEB-INF/index", "loginStatus", LoginStatus.FAILED);
    }
}