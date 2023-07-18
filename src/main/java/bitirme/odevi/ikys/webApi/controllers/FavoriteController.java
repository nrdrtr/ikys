package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.FavoriteService;
import bitirme.odevi.ikys.bussiness.requests.JobSeekerAddFavorite;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Favorite;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/favori")
@AllArgsConstructor
public class FavoriteController {

    private FavoriteService favoriteService;


    @GetMapping("/getFavoriteByIsArayanId")
    public DataResult<List<Favorite>> getFavoriteByIsArayanId(@RequestParam int id) {
        return this.favoriteService.getFavoriByIsArayanId(id);
    }

    @PostMapping("/addFavorite")
    public ResponseEntity<Result> addFavorite(@RequestBody JobSeekerAddFavorite jobSeekerAddFavorite) {
        HashMap<String, String> result = new HashMap<>();
        try {
            this.favoriteService.addFavoriteAdvertisemement(jobSeekerAddFavorite);
            result.put("message", "İş ilanı favorilere eklendi");
            return ResponseEntity.ok().body(new Result(true, "İş ilanı favorilere eklendi"));
        } catch (Exception e) {

            result.put("message", "İş ilanı favorilere eklenemedi");
            return ResponseEntity.badRequest().body(new Result(false, "İş ilanı favorilere eklenemedi"));
        }
    }

//    @DeleteMapping("/deleteFavoriteBy/{id}")
//    public ResponseEntity<Result> removeFavoriteAdvertisement(@RequestBody JobSeekerRemoveFavorite jobSeekerRemoveFavorite) {
//        Result result = favoriteService.removeFavoriteAdvertisement(jobSeekerRemoveFavorite);
//        return ResponseEntity.ok(result);
//    }


    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.favoriteService.delete(id);
    }

}
