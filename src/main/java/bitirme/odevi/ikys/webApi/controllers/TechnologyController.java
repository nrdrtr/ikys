package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.TechnologyService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Technology;
import bitirme.odevi.ikys.entitites.dto.TechnologyUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teknoloji")
public class TechnologyController {

    private TechnologyService technologyService;

    @GetMapping("/getall")
    public DataResult<List<Technology>> getTeknoloji(){

        return this.technologyService.getTeknoloji();
    }

    @PostMapping("/add")
    public Result save(@RequestBody Technology teknoloji){
        return this.technologyService.add(teknoloji);
    }


    @PutMapping("/updateTeknoloji")
    public Result updateTechnology(@RequestBody TechnologyUpdateDto pl) {
        return this.technologyService.updateTechnology(pl);
    }



    @DeleteMapping("/deleteTeknolojiById")
    public Result deleteTechnologyById(@RequestParam int id) {
        return this.technologyService.deleteTeknolojiById(id);
    }
}
