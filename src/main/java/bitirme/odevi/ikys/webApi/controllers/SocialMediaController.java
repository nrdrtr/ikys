package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.SocialMediaService;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.SocialMedia;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sosyalmedya")
public class SocialMediaController {

    private SocialMediaService socialMediaService;
    @PostMapping("/add")//http://localhost:8080/api/sosyalmedya/add
    public ResponseEntity<?> add(@RequestBody SocialMedia socialMedia) {
             this.socialMediaService.addSocialMedia(socialMedia);
             return ResponseEntity.ok(new Result(true, "Sosyal medya hesabı başarıyla eklendi"));
    }


    @GetMapping("/getall")//http://localhost:8080/api/sosyalmedya/getall
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.socialMediaService.getAll());
    }



}
