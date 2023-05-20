package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.JobAdvertisementService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobAdvertisement;
import bitirme.odevi.ikys.entitites.dto.EmployerWithJobAdvertisementDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        return this.jobAdvertisementService.getAllSorted();
    }

//    @GetMapping("/getByEmployerId")
//    public DataResult<List<JobAdvertisement>> getByEmployerId(@RequestParam int employerId) {
//        return this.jobAdvertisementService.getByEmployerId(employerId);
//    }
    @GetMapping("/getByIsActiveTrue")
    public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
        return this.jobAdvertisementService.getAllByIsActiveTrue();
    }
    @GetMapping("/getById/{id}")
    public DataResult<JobAdvertisement> findByIsIlaniId(@PathVariable("id") int id){
          return this.jobAdvertisementService.findById(id);

    }

    @GetMapping("/getAllByPage")
    DataResult<List<JobAdvertisement>> getByPage(int pageNo, int pageSize) {
        return this.jobAdvertisementService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getByIsActiveTrue1")
    public DataResult<List<JobAdvertisement>> findAllByIsActiveTrue(@RequestParam boolean isDesc) {
        return this.jobAdvertisementService.findAllByIsActiveTrue(isDesc);
    }

    @GetMapping("/getBySehir")
    public DataResult<List<JobAdvertisement>> findBySehir(@RequestParam String sehir) {
        return this.jobAdvertisementService.findBySehir(sehir);
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.save(jobAdvertisement);
    }

    @GetMapping("/getByDescription")
    public List<JobAdvertisement> getByDescription(@RequestParam String description) {
        return this.jobAdvertisementService.findByDescriptionStartsWith(description);
    }

    @GetMapping("/getIsverenWithIsIlanıDetails")
    public List<EmployerWithJobAdvertisementDto> getIsverenWithIsIlanıDetails() {
        return this.jobAdvertisementService.getIsverenWithIsIlanıDetails();
    }


    @GetMapping("/getByJobPositionId")
    public List<JobAdvertisement> findByIsPozisyonId(int isPozisyonu) {
        return this.jobAdvertisementService.findByIsPozisyonId(isPozisyonu);
    }


}
