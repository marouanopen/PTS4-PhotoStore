package fotowebstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadController {

    @GetMapping("/fileupload")
    public String fileupload() {
        return "WEB-INF/fileupload";
    }
}
