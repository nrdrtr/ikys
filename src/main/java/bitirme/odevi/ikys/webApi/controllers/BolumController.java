package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.BolumService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Bolum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bolumler")
@CrossOrigin
public class BolumController {

    private BolumService bolumService;

    @Autowired
    public BolumController(BolumService bolumService) {
        this.bolumService = bolumService;
    }

    @GetMapping("/getall")
    public DataResult<List<Bolum>> getAll(){
        return this.bolumService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Bolum bolum){
       return this.bolumService.add(bolum);
    }
}
