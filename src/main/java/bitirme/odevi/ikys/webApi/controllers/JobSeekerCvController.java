package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.concretes.JobSeekerCVService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curriculum-vitae")
public class JobSeekerCvController {

    private final JobSeekerCVService jobSeekerCvService;

    public JobSeekerCvController(JobSeekerCVService jobSeekerCvService) {
        this.jobSeekerCvService = jobSeekerCvService;
    }

//    @PostMapping("/add")
//    public ResponseEntity<CurriculumVitae> addCurriculumVitae(@RequestBody JobSeekerCvAddRequest request) {
//        CurriculumVitae cv = jobSeekerCvService.addCurriculumVitae(request);
//        return ResponseEntity.ok(cv);
//    }
}
