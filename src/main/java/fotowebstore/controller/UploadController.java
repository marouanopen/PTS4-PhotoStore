package fotowebstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.*;

@Controller
public class UploadController {

    @GetMapping(value = "/fileupload")
    public String fileupload() {
        return "fileupload";
    }

    @PostMapping(value = "/uploadfile")
    public String uploadImage(@RequestParam("image") MultipartFile file) {
        final String sourcePath = "C:\\users\\peter\\desktop\\"; //Path needs to be changed.
        BufferedOutputStream outputStream = null;

        try {
            //Get bytes from file and create file on disk with the given path.
            byte[] buffer = file.getBytes();
            File output = new File(sourcePath + file.getOriginalFilename());

            //Write data to file
            outputStream = new BufferedOutputStream(new FileOutputStream(output));
            outputStream.write(buffer, 0, buffer.length);

            //Create pixelated version
            BufferedImage image = pixelateImage(buffer);
            ImageIO.write(image, "jpg", new File(sourcePath + "pixelated_" + file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Close outputStream
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "fileupload";
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
