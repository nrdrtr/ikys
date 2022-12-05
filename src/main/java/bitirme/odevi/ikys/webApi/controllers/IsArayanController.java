package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.IsArayanService;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isarayan")
public class IsArayanController {

    private IsArayanService isArayanService;

    @Autowired
    public IsArayanController(IsArayanService isArayanService) {
        super();
        this.isArayanService = isArayanService;
    }

    @GetMapping("/getall")
    public List<IsArayan> getIsArayan(){
        return this.isArayanService.getAllIsArayan();
    }

    @PostMapping("/save")
    public void save( @RequestBody IsArayan isArayan){
        this.isArayanService.save(isArayan);
    }
}
