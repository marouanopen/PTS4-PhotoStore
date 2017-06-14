package fotowebstore.controller;

import fotowebstore.dao.AlbumDao;
import fotowebstore.dao.PhotoDao;
import fotowebstore.dao.UserDao;
import fotowebstore.entities.Album;
import fotowebstore.entities.Photo;
import fotowebstore.entities.User;
import fotowebstore.util.SerialKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.List;

@Controller
public class AlbumController {

    private AlbumDao albumDao;
    private PhotoDao photoDao;
    private UserDao userDao;

    private HttpSession session;

    @Autowired
    public AlbumController(AlbumDao albumDao, PhotoDao photoDao, UserDao userDao, HttpSession session) {
        this.albumDao = albumDao;
        this.photoDao = photoDao;
        this.userDao = userDao;
        this.session = session;
    }

    @GetMapping("/albumoverview")
    public ModelAndView albumOverview() {
        List<Album> albums = albumDao.findAll();

        return new ModelAndView("WEB-INF/albumoverview", "albums", albums);
    }

    @PostMapping("/createalbum")
    public ModelAndView createAlbum(@RequestParam("name") String albumName) {
        User user = userDao.findById(1);
        Album album = new Album(user, albumName, SerialKey.generate());
        albumDao.create(album);

        return new ModelAndView("WEB-INF/albumcreation", "album", album);
    }

    @PostMapping("/photooverview")
    public ModelAndView photoOverview(@RequestParam("id") int id) {
        Album album = albumDao.find(id);
        return new ModelAndView("WEB-INF/photooverview", "album", album);
    }

    @PostMapping("/uploadfile")
    public ModelAndView uploadImage(@RequestParam("image") MultipartFile file,
                                    @RequestParam("albumId") int albumId,
                                    @RequestParam("price") double price) {
        //final String sourcePath = new File(new File("").getAbsolutePath()).getPath().concat("\\images\\");
        //final String sourcePath = "C:\\Users\\peter\\Desktop\\Java projects\\FotoWebstore\\src\\main\\webapp\\resources";
        final String sourcePath = "../webapps/images/";

        BufferedOutputStream outputStream = null;

        Photo photo = new Photo(file.getOriginalFilename(), price);
        Album album = albumDao.find(albumId);
        photo.setName(photo.getName().replace(' ', '_'));
        photo.setAlbum(album);
        photoDao.create(photo);

        try {
            //Get bytes from file and create file on disk with the given path.
            byte[] buffer = file.getBytes();
            File output = new File(sourcePath + photo.getId() + "_" + photo.getName());

            //Write data to file
            outputStream = new BufferedOutputStream(new FileOutputStream(output));
            outputStream.write(buffer, 0, buffer.length);

            //Create pixelated version
            BufferedImage image = pixelateImage(buffer);
            ImageIO.write(image, "jpg", new File(sourcePath + photo.getId() + "_pixelated_" + photo.getName()));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Close outputStream
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new ModelAndView("WEB-INF/albumcreation", "album", album);
    }

    private BufferedImage pixelateImage(byte[] buffer) throws IOException {
        //Size of the new pixels
        final int PIX_SIZE = 10;

        //Turn buffer into image.
        InputStream input = new ByteArrayInputStream(buffer);
        BufferedImage image = ImageIO.read(input);

        //Get writable raster from image.
        Raster src = image.getData();
        WritableRaster dest = src.createCompatibleWritableRaster();

        //Pixelate the raster.
        for (int y = 0; y < src.getHeight(); y += PIX_SIZE) {
            for (int x = 0; x < src.getWidth(); x += PIX_SIZE) {
                double[] pixel = new double[3];
                pixel = src.getPixel(x, y, pixel);

                for (int yd = y; (yd < y + PIX_SIZE) && (yd < dest.getHeight()); yd++) {
                    for (int xd = x; (xd < x + PIX_SIZE) && (xd < dest.getWidth()); xd++) {
                        dest.setPixel(xd, yd, pixel);
                    }
                }
            }
        }

        //Set the image to the contents of the raster and close the inputstream
        image.setData(dest);
        input.close();
        return image;
    }
}
