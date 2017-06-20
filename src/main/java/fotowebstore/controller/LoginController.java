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

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    private UserDao userDao;
    private HttpSession session;

    @Autowired
    public LoginController(UserDao userDao, HttpSession session) {
        this.userDao = userDao;
        this.session = session;
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

                if (hashedPassword.equals(user.getPassword())) {
                    session.setMaxInactiveInterval(1800);
                    session.setAttribute("userData", user);
                    return new ModelAndView("WEB-INF/overview", "user", user);
                }

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

            return new ModelAndView("WEB-INF/index", "loginStatus", LoginStatus.SUCCESS);
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

    @GetMapping("/useroverview")
    public ModelAndView userOverview(){
        User user = userDao.findById(8);
        return new ModelAndView("WEB-INF/useroverview", "user", user);
    }

    @PostMapping("/useroverview")
    public ModelAndView requestPhotographer()
    {
        User user = userDao.findById(8);
        user.setRequesting(true);
        userDao.update(user);
        return new ModelAndView("WEB-INF/useroverview", "user", user);
    }
}