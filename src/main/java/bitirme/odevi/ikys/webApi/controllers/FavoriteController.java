package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.FavoriteService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Favorite;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favori")
@AllArgsConstructor
public class FavoriteController {

    private FavoriteService favoriteService;


    @GetMapping("/getFavoriteByIsArayanId")
    public DataResult<List<Favorite>>getFavoriteByIsArayanId(@RequestParam int id){
       return this.favoriteService.getFavoriByIsArayanId(id);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Favorite favorite){
      return  this.favoriteService.save(favorite);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.favoriteService.delete(id);
    }
}
