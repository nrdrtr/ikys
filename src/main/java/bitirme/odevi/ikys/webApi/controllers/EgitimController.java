package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.EgitimService;
import bitirme.odevi.ikys.entitites.concretes.Egitim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/egitim")
public class EgitimController {

    private EgitimService egitimService;

    @Autowired
    public EgitimController(EgitimService egitimService) {
        this.egitimService = egitimService;
    }

    @GetMapping("/getall")
    public List<Egitim> getall(){
        return this.egitimService.egitimGetAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Egitim egitim){
        this.egitimService.save(egitim);
    }


    @GetMapping("/pages")
    public List<Egitim> getAll(@PathVariable Pageable pageable,int id){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        return (List<Egitim>) this.egitimService.findAllByEgitim(1,pageable);
    }
}
