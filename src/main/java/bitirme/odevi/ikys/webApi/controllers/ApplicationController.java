package bitirme.odevi.ikys.webApi.controllers;


import bitirme.odevi.ikys.bussiness.abstracts.ApplicationService;
import bitirme.odevi.ikys.bussiness.requests.JobSeekerAdvertApplicationRequest;
import bitirme.odevi.ikys.core.utilities.exceptions.ResourceNotFoundException;
import bitirme.odevi.ikys.entitites.concretes.Application;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications/")
@AllArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;



//    @GetMapping("/getByJobSeekerId/{jobSeekerId}")
//    public ResponseEntity<?> getByJobSeekerId(@PathVariable("jobSeekerId") int jobSeekerId) {
//        List<Application> applications = this.applicationService.getAllByJobSeekerId(jobSeekerId);
//        if (applications.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Belirtilen ID'ye sahip başvuru bulunamadı.");
//        }
//        return ResponseEntity.ok(applications);
//    }



    @PostMapping("apply")
    public ResponseEntity<String> applyToJobAdvertisement(@RequestBody JobSeekerAdvertApplicationRequest jobSeekerAdvertApplicationRequest) {
        applicationService.createApplication(jobSeekerAdvertApplicationRequest);
        return ResponseEntity.ok("İlana başarıyla başvuruldu");
    }
    @GetMapping("{jobAdvertisementId}/")
    public List<Application> getApplicationsByJobAdvertisementId(@PathVariable int jobAdvertisementId) {
        return applicationService.getApplicationsByJobAdvertisementId(jobAdvertisementId);
    }


    @PutMapping("approve/{applicationId}")
    public ResponseEntity<String> approveApplication(@PathVariable int applicationId) throws ResourceNotFoundException {

    this.applicationService.approveApplication(applicationId);
        return new ResponseEntity<>("Başvuru onaylandı", HttpStatus.OK);
    }

    @PutMapping("reject/{applicationId}")
    public ResponseEntity<String> rejectApplication(@PathVariable int applicationId) {
         this.applicationService.rejectApplication(applicationId);
        return new ResponseEntity<>("Başvuru reddedildi", HttpStatus.OK);
    }

    @GetMapping("employerId/{employerId}")
    public List<Application> getApplicationsByEmployerId(@PathVariable int employerId) {
        return applicationService.getApplicationsByEmployerId(employerId);
    }
}
