package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.TeknolojiService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Teknoloji;
import bitirme.odevi.ikys.entitites.dto.TechnologyUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teknoloji")
@CrossOrigin
public class TeknolojiController {

    private TeknolojiService teknolojiService;

    @Autowired
    public TeknolojiController(TeknolojiService teknolojiService) {
        this.teknolojiService = teknolojiService;
    }

    @GetMapping("/getall")
    public DataResult<List<Teknoloji>> getTeknoloji(){

        return (DataResult<List<Teknoloji>>) this.teknolojiService.getTeknoloji();
    }

    @PostMapping("/add")
    public Result save(@RequestBody Teknoloji teknoloji){
        return this.teknolojiService.add(teknoloji);
    }


    @PutMapping("/updateTeknoloji")
    public Result updateTechnology(@RequestBody TechnologyUpdateDto pl) {
        return this.teknolojiService.updateTechnology(pl);
    }



    @DeleteMapping("/deleteTeknolojiById")
    public Result deleteTechnologyById(@RequestParam int id) {
        return this.teknolojiService.deleteTeknolojiById(id);
    }
}
