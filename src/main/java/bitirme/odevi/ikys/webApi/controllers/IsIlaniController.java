package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.IsIlanıService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsIlani;
import bitirme.odevi.ikys.entitites.concretes.IsPozisyonu;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isilani")
@CrossOrigin
@AllArgsConstructor
public class IsIlaniController {

    private IsIlanıService isIlaniService;

    @GetMapping("/getall")
    public DataResult<List<IsIlani>> getAll() {
        return this.isIlaniService.getAll();
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<IsIlani>> getAllSorted() {
        return this.isIlaniService.getAllSorted();
    }

    @GetMapping("/getBy/getJobAdvertisementDetails/{id}")
    public DataResult<IsIlani> findByIsIlaniId(@PathVariable("id") int id){
          return this.isIlaniService.findById(id);

    }
    @GetMapping("/getAllByPage")
    DataResult<List<IsIlani>> getByPage(int pageNo, int pageSize) {
        return this.isIlaniService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getByIsActiveTrue")
    public DataResult<List<IsIlani>> findAllByIsActiveTrue(@RequestParam boolean isDesc) {
        return this.isIlaniService.findAllByIsActiveTrue(isDesc);
    }

    @GetMapping("/getBySehir")
    public DataResult<IsIlani> findBySehir(@RequestParam String sehir) {
        return this.isIlaniService.findBySehir(sehir);
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


    @GetMapping("/getByIsPozisyonId")
    public List<IsIlani> findByIsPozisyonId(int isPozisyonu) {
        return this.isIlaniService.findByIsPozisyonId(isPozisyonu);
    }


}
