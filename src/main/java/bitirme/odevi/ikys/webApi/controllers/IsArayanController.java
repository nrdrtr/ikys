package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.IsArayanService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public DataResult<List<IsArayan>> getIsArayan(){
        return this.isArayanService.getAllIsArayan();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody IsArayan isArayan){
        if (isArayanService.save(isArayan).isSuccess()){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST, HttpStatus.valueOf(" tüm alanlar doldurulmalıdır"));
        }


}}
