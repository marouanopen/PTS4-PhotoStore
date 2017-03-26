package fotowebstore.controller;

import fotowebstore.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Arjan on 25-3-2017.
 */
@Controller
public class AdminController {

    @RequestMapping("/overview")
    public ModelAndView overview(){
        ArrayList<User> photographers = new ArrayList<User>();

        //Testcode
        User user1 = new User("Persoon1", "Adres1", 1, "1100","Stad1", "email@email.com");
        User user2 = new User("Persoon2", "Adres2", 2, "1100","Stad2", "email@email.com");
        User user3 = new User("Persoon3", "Adres3", 3, "1100","Stad3", "email@email.com");
        User user4 = new User("Persoon4", "Adres4", 4, "1100","Stad4", "email@email.com");

        //Change status to true
        user1.changePhotographerStatus();
        user2.changePhotographerStatus();
        user4.changePhotographerStatus();

        //Create Product for user4
        ArrayList<Photo> photos = new ArrayList<Photo>();
        photos.add(new Photo(12));
        user4.addProduct(new Product(12, photos));

        //Add users to list
        photographers.add(user1);
        photographers.add(user2);
        photographers.add(user3);
        photographers.add(user4);

        return new ModelAndView("overview", "photographers", photographers);
    }
}
