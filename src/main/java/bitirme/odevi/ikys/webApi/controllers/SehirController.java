package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.SehirService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.Sehir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sehirler")
@CrossOrigin
public class SehirController {

    private SehirService sehirService;

    @Autowired
    public SehirController(SehirService sehirService) {
        this.sehirService = sehirService;
    }



    @GetMapping("/getall")
    public DataResult<List<Sehir>> getAll(){
        return this.sehirService.getAll();
    }
}
