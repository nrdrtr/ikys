package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.EducationService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Education;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/egitim")
public class EducationController {

    private EducationService educationService;

    @GetMapping("/getall")
    public DataResult<List<Education>> getall() {
        return this.educationService.egitimGetAll();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Education education) {
        return this.educationService.save(education);
    }


    @GetMapping("/getEducationsByCvId")
    public DataResult<List<Education>> getEducationsByCvId(@RequestParam int id) {
        return this.educationService.egitimGetEgitimByOzgecmisId(id);
    }


    @DeleteMapping("/deleteEducationById")
    public Result deleteEducationById(@RequestParam int id) {
        return this.educationService.deleteEgitimById(id);
    }


//    @GetMapping("/pages")
//    public List<Egitim> getAll(@PathVariable Pageable pageable,int id){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
//        return (List<Egitim>) this.educationService.findAllByEgitim(1,pageable);
//    }
}
