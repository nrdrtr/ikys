package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.OkulService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.Okul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/okullar")
@CrossOrigin
public class OkulController {

    private OkulService okulService;


    @Autowired
    public OkulController(OkulService okulService) {
        this.okulService = okulService;
    }

    @GetMapping("/getall")
    public DataResult<List<Okul>> getall(){
      return   this.okulService.getAll();
    }
}
