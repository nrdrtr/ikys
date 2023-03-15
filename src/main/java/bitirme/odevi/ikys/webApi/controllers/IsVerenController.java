package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.IsVerenService;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/isveren")
@RestController
@CrossOrigin
public class IsVerenController {

    private final IsVerenService isVerenService;

    @Autowired
    public IsVerenController(IsVerenService isVerenService) {
        this.isVerenService = isVerenService;
    }

    @GetMapping("/getall")//methodu list döneceksin
    public List<IsVeren> getIsVeren() {
       return this.isVerenService.isVeren();
    }


    @PostMapping("/save")
    public void save(@RequestBody  IsVeren isVeren){
        this.isVerenService.save(isVeren);


    }

    @GetMapping("/getIsverenWithIsIlanıDetails")
    public List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails(){
        return this.isVerenService.getIsverenWithIsIlanıDetails();
    }


}
