package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.FavoriService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Favori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favori")
@CrossOrigin//frontend ile bağlantı kurmak için
public class FavoriController {

    private FavoriService favoriService;

    @Autowired
    public FavoriController(FavoriService favoriService) {
        this.favoriService = favoriService;
    }


    @GetMapping("/getFavoriteByIsArayanId")
    public DataResult<List<Favori>>getFavoriteByIsArayanId(@RequestParam int id){
       return this.favoriService.getFavoriByIsArayanId(id);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Favori favori){
      return  this.favoriService.save(favori);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.favoriService.delete(id);
    }
}
