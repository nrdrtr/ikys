package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.IsIlanıService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsIlani;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isilani")
public class IsIlaniController {

    private IsIlanıService isIlaniService;

    @Autowired
    public IsIlaniController(IsIlanıService isIlaniService) {
        this.isIlaniService = isIlaniService;
    }


     @GetMapping("/getall")
     public DataResult<List<IsIlani>> getAll(){
         return this.isIlaniService.getAll();
     }

    @GetMapping("/getAllDesc")
    public DataResult<List<IsIlani>> getAllSorted() {
        return this.isIlaniService.getAllSorted();
    }

    @GetMapping("/getAllByPage")
    DataResult<List<IsIlani>> getByPage(int pageNo, int pageSize) {
        return this.isIlaniService.getAll(pageNo, pageSize);
    }


    @PostMapping("/add")
    public Result add(@RequestBody IsIlani isIlani) {
        return this.isIlaniService.save(isIlani);
    }

    @GetMapping("/getByDescription")
    public List<IsIlani> getByDescription(@RequestParam String description) {
        return this.isIlaniService.findByDescriptionStartsWith(description);
    }

    @GetMapping("/getIsverenWithIsIlanıDetails")
    public List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails() {
        return this.isIlaniService.getIsverenWithIsIlanıDetails();
    }



}
