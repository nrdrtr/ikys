package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.EgitimService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Egitim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/egitim")
@CrossOrigin
public class EgitimController {

    private EgitimService egitimService;

    @Autowired
    public EgitimController(EgitimService egitimService) {
        this.egitimService = egitimService;
    }

    @GetMapping("/getall")
    public DataResult<List<Egitim>> getall() {
        return this.egitimService.egitimGetAll();
    }

    @PostMapping("/save")
    public Result save(@RequestBody Egitim egitim) {
        return this.egitimService.save(egitim);
    }


    @GetMapping("/getEducationsByCvId")
    public DataResult<List<Egitim>> getEducationsByCvId(@RequestParam int id) {
        return this.egitimService.egitimGetEgitimByOzgecmisId(id);
    }


    @DeleteMapping("/deleteEducationById")
    public Result deleteEducationById(@RequestParam int id) {
        return this.egitimService.deleteEgitimById(id);
    }


//    @GetMapping("/pages")
//    public List<Egitim> getAll(@PathVariable Pageable pageable,int id){
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
//        return (List<Egitim>) this.egitimService.findAllByEgitim(1,pageable);
//    }
}
