package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.IDillerService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.Dil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/diller")
public class DilController {

    private IDillerService  dillerService;

    @Autowired
    public DilController(IDillerService dillerService) {
        super();
        this.dillerService = dillerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Dil>> getDiller(){
        return this.dillerService.getDiller();
    }

    @GetMapping("/getByDilAdi")//yanlış DÜZELECEK
    public DataResult<List<Dil>> getDilAdi (@RequestParam String name){
        return this.dillerService. findAllByName();
    }





}
