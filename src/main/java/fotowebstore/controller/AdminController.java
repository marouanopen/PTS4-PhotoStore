package fotowebstore.controller;

import fotowebstore.dao.AlbumDao;
import fotowebstore.dao.PhotoDao;
import fotowebstore.dao.PhotoDaoImplHibernate;
import fotowebstore.dao.UserDao;
import fotowebstore.entities.Album;
import fotowebstore.entities.Photo;
import fotowebstore.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import java.util.List;

@Controller
public class AdminController {

    private final UserDao userDao;
    private final PhotoDao photoDao;
    private final AlbumDao albumDao;

    @Autowired
    public AdminController(UserDao userDao, PhotoDao photoDao, AlbumDao albumDao){
        this.userDao = userDao;
        this.photoDao = photoDao;
        this.albumDao = albumDao;
    }

    @GetMapping("/requests")
    public ModelAndView requests(){
        List<User> photographerRequests = userDao.findPhotographerRequests();
        return new ModelAndView("WEB-INF/requests", "users", photographerRequests);
    }

    @RequestMapping("/accept/{id}")
    public ModelAndView accept(@PathVariable("id") int id) {
        User user = userDao.findById(id);
        user.setRequesting(false);
        user.setPhotographer(true);
        userDao.update(user);
        List<User> photographerRequests = userDao.findPhotographerRequests();
        return new ModelAndView("WEB-INF/requests", "users", photographerRequests);
    }

    @RequestMapping("/deny/{id}")
    public ModelAndView deny(@PathVariable("id") int id) {
        User user = userDao.findById(id);
        user.setRequesting(false);
        userDao.update(user);

        List<User> photographerRequests = userDao.findPhotographerRequests();
        return new ModelAndView("WEB-INF/requests", "users", photographerRequests);
    }

    @RequestMapping("/overview")
    public ModelAndView overview(){

        List<User> photographers = userDao.findAll();
        return new ModelAndView("WEB-INF/overview", "photographers", photographers);
    }

    @RequestMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") int id) {
        User user = userDao.findById(id);
        userDao.remove(user);

        List<User> photographers = userDao.findAll();
        return new ModelAndView("WEB-INF/overview", "photographers", photographers);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        User user = userDao.findById(id);

        return new ModelAndView("WEB-INF/edituser", "user", user);
    }

    @PostMapping("/edit")
    public ModelAndView edituser(HttpSession session,
                                 @RequestBody MultiValueMap<String, String> form) {

        try {
            User user = userDao.findById(Integer.valueOf(form.getFirst("id")));
            user.setName(form.getFirst("name"));
            user.setEmail(form.getFirst("email"));
            user.setStreet(form.getFirst("street"));
            user.setHouseNumber(form.getFirst("housenumber"));
            user.setZipCode(form.getFirst("zipcode"));
            user.setCity(form.getFirst("city"));

            userDao.update(user);

            List<User> photographers = userDao.findAll();
            return new ModelAndView("WEB-INF/overview", "photographers", photographers);
        } catch (Exception ex){
            ex.printStackTrace();

            List<User> photographers = userDao.findAll();
            return new ModelAndView("WEB-INF/overview", "photographers", photographers);
        }
    }

    @RequestMapping("/photooverviewadmin")
    public ModelAndView photooverviewadmin(){

        List<Photo> photos = photoDao.findAll();
        return new ModelAndView("WEB-INF/photooverviewadmin", "photos", photos);
    }

    @GetMapping("/hide/{id}")
    public ModelAndView hide(@PathVariable("id") int id){
        Photo photo = photoDao.find(id);
        photo.setHidden(true);
        photoDao.update(photo);

        List<Photo> photos = photoDao.findAll();
        return new ModelAndView("WEB-INF/photooverviewadmin", "photos", photos);
    }

    @GetMapping("/show/{id}")
    public ModelAndView show(@PathVariable("id") int id){
        Photo photo = photoDao.find(id);
        photo.setHidden(false);
        photoDao.update(photo);

        List<Photo> photos = photoDao.findAll();
        return new ModelAndView("WEB-INF/photooverviewadmin", "photos", photos);
    }

    @RequestMapping("/albumoverviewadmin")
    public ModelAndView albumoverviewadmin(){

        List<Album> albums = albumDao.findAll();
        return new ModelAndView("WEB-INF/albumoverviewadmin", "albums", albums);
    }

    @GetMapping("/hidealbum/{id}")
    public ModelAndView hidealbum(@PathVariable("id") int id){
        Album album = albumDao.find(id);
        album.setHidden(true);
        albumDao.update(album);

        List<Album> albums = albumDao.findAll();
        return new ModelAndView("WEB-INF/albumoverviewadmin", "albums", albums);
    }

    @GetMapping("/showalbum/{id}")
    public ModelAndView showalbum(@PathVariable("id") int id){
        Album album = albumDao.find(id);
        album.setHidden(false);
        albumDao.update(album);

        List<Album> albums = albumDao.findAll();
        return new ModelAndView("WEB-INF/albumoverviewadmin", "albums", albums);
    }
}
