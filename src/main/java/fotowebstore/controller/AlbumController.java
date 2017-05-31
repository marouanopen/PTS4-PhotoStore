package fotowebstore.controller;

import fotowebstore.dao.AlbumDao;
import fotowebstore.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    private AlbumDao albumDao;

    public AlbumController(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    @GetMapping("/albumoverview")
    public ModelAndView albumOverview() {
        List<Album> albums = albumDao.findAll();
        return new ModelAndView("WEB-INF/albumoverview", "albums", albums);
    }

    @PostMapping("/createalbum")
    public ModelAndView createAlbum(@RequestParam("name") String albumName) {
        Album album = new Album(albumName);

        return new ModelAndView("WEB-INF/albumcreation", "album", album);
    }

    @PostMapping("/photooverview")
    public ModelAndView photoOverview(@RequestParam("album") Album album) {
        return new ModelAndView("WEB-INF/photooverview", "album", album);
    }
}
