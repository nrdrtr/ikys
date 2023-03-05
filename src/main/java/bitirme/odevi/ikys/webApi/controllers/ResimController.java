package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.ResimService;
import bitirme.odevi.ikys.entitites.concretes.Resim;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/resimler")
@CrossOrigin
@AllArgsConstructor
public class ResimController {

    private  ResimService resimService;


    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam(required = false,value = "file") MultipartFile file) {
        try {
            Resim image = resimService.uploadImage(file);
            return ResponseEntity.ok(image);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
