package fotowebstore.controller;

import fotowebstore.dao.UserDao;
import fotowebstore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private final UserDao userDao;

    @Autowired
    public AdminController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/requests")
    public ModelAndView requests(){
        List<User> request_users = new ArrayList<User>();
        List<User> users = userDao.findAll();
        for (User user: users) {
            if (user.getPhotographer()){
                request_users.add(user);
            }
        }

        List<User> requesters = userDao.findPhotographerRequests();
        return new ModelAndView("WEB-INF/requests", "users", requesters);
    }

    @RequestMapping("/overview")
    public ModelAndView overview(){
     /*   ArrayList<User> users = new ArrayList<User>();

        //Testcode
        User user1 = new User("Persoon1", "Adres1", 1, "1100","Stad1", "email@email.com", "password");
        User user2 = new User("Persoon2", "Adres2", 2, "1100","Stad2", "email@email.com", "password");
        User user3 = new User("Persoon3", "Adres3", 3, "1100","Stad3", "email@email.com", "password");
        User user4 = new User("Persoon4", "Adres4", 4, "1100","Stad4", "email@email.com", "password");

        //Create Product for user4
        ArrayList<Photo> photos = new ArrayList<Photo>();
        //photos.add(new Photo(12));
        user4.addProduct(new Product(12, photos));

        //Add users to list
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        ArrayList<User> photographers = new ArrayList<User>();
        for (User user : users) {
            if (user.getPhotographer()){
                photographers.add(user);
            }
        }

        //Niet werkende code. Test om List Users + User mee te geven aan de View
        Map<Object, ArrayList<User>> model = new HashMap<Object, ArrayList<User>>();
        model.put(user1, users);*/
        ArrayList<User> photographers = new ArrayList<User>();
        return new ModelAndView("WEB-INF/overview", "photographers", photographers);
    }
}
