package fotowebstore.controller;

import fotowebstore.dao.AlbumDao;
import fotowebstore.entities.Album;
import fotowebstore.entities.User;
import fotowebstore.util.EmailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class VoucherController {

    private HttpSession session;
    private AlbumDao albumDao;

    @Autowired
    public VoucherController(HttpSession session, AlbumDao albumDao) {
        this.session = session;
        this.albumDao = albumDao;
    }

    @PostMapping("/email/voucher")
    public String sendVoucherMail(@RequestParam("email") String email,
                                  @RequestParam("voucherCode") String voucherCode) {
        String lineSeparator = System.getProperty("line.separator");
        User user = (User) session.getAttribute("userData");

        EmailHandler.send(email,
                "The album you requested is ready.",
                "Hello," + lineSeparator + lineSeparator +
                        "The album has been finished and uploaded to the website!" + lineSeparator +
                        "Click this link to add it to your account for viewing and buying!" + lineSeparator +
                        "http://145.93.133.54:8080/voucher/" + voucherCode + lineSeparator + lineSeparator +
                        "Sincerely," + lineSeparator +
                        user.getName());
        return "WEB-INF/overview";
    }

    @GetMapping("/voucher/{vouchercode}")
    public String voucherFromLink(@PathVariable("vouchercode") String voucherCode) {
        useVoucherCode(voucherCode);

        return "WEB-INF/albumoverview";
    }

    @PostMapping("/voucher")
    public String voucherFromPOST(@RequestParam("vouchercode") String voucherCode) {
        useVoucherCode(voucherCode);

        return "WEB-INF/albumoverview";
    }

    private boolean useVoucherCode(String voucherCode) {
        User user = (User) session.getAttribute("userData");
        Album album = albumDao.findByVoucherCode(voucherCode);

        if (user == null) return false;
        if (album == null) return false;
        if (album.isHidden()) return false;

        albumDao.linkUserAndAlbum(user, album);
        user.getVoucherAlbums().add(album);

        return true;
    }
}
