package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.JobAdvertisementService;
import bitirme.odevi.ikys.bussiness.requests.EmployerJobAdvertisementsRequest;
import bitirme.odevi.ikys.bussiness.requests.JobApplicationDTO;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;


    @GetMapping("/{id}/applicants")
    public ResponseEntity<List<JobApplicationDTO>> getApplicantsByJobAdvertisement(@PathVariable int id) {
        List<JobApplicationDTO> applicants = this.jobAdvertisementService.getApplicantsByJobAdvertisement(id);

        if (applicants.isEmpty()) {
            // Handle case when job advertisement or applicants are not found
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(applicants);
    }
    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        return this.jobAdvertisementService.getAllSorted();
    }


    @GetMapping("/getByEmployerId")
    ResponseEntity<List<JobAdvertisement>> findByEmployerId(@RequestParam int employerId) {
        return ResponseEntity.ok(this.jobAdvertisementService.findByEmployerId(employerId));
    }


    @PostMapping("/save")
    public ResponseEntity<Result> add(@RequestBody EmployerJobAdvertisementsRequest  request) throws Exception {
           HashMap<String, String> result = new HashMap<>();
        try {
            this.jobAdvertisementService.save(request);
            result.put("message", "İş ilanı başarıyla eklendi");
            return ResponseEntity.ok().body(new Result(true, "İş ilanı başarıyla eklendi"));
        } catch (Exception e) {

            result.put("message", "İş ilanı eklenemedi");
            return ResponseEntity.badRequest().body(new Result(false, "İş ilanı eklenemedi"));
        }
    }



    @GetMapping("/getByIsActiveTrue")
    public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
        return this.jobAdvertisementService.getAllByIsActiveTrue();
    }

    @GetMapping("/getById/{id}")
    public DataResult<JobAdvertisement> findByIsIlaniId(@PathVariable("id") int id) {
        return this.jobAdvertisementService.findById(id);

    }

    @GetMapping("/getAllByPage")
    DataResult<List<JobAdvertisement>> getByPage(int pageNo, int pageSize) {
        return this.jobAdvertisementService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getByIsActiveTrueOrFalse")
    public DataResult<List<JobAdvertisement>> findAllByIsActiveTrue(@RequestParam boolean isDesc) {
        return this.jobAdvertisementService.findAllByIsActiveTrue(isDesc);
    }

    @GetMapping("/getByCityName")
    public ResponseEntity<List<JobAdvertisement>> findByCity(@RequestParam String cityName) {
        return ResponseEntity.ok(this.jobAdvertisementService.findByCityName(cityName));
    }


    @GetMapping("/getByDescription")
    public List<JobAdvertisement> getByDescription(@RequestParam String description) {
        return this.jobAdvertisementService.findByDescriptionStartsWith(description);
    }


    @PostMapping("/setStatus")
    public Result setStatus(@RequestParam int jobAdvertisementId, @RequestParam int employerId, @RequestParam boolean status) {
        return this.jobAdvertisementService.setStatus(jobAdvertisementId, employerId, status);
    }


    @GetMapping("/getByJobPositionId")
    public List<JobAdvertisement> findByIsPozisyonId(int isPozisyonu) {
        return this.jobAdvertisementService.findByIsPozisyonId(isPozisyonu);
    }


}
