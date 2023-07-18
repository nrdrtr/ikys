package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.EmployerService;
import bitirme.odevi.ikys.bussiness.abstracts.JobAdvertisementService;
import bitirme.odevi.ikys.bussiness.requests.JobApplicationDTO;
import bitirme.odevi.ikys.bussiness.requests.authRequests.EmployerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.EmployerUpdateRequest;
import bitirme.odevi.ikys.bussiness.requests.authRequests.LoginRequest;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.ApplicationDto;
import bitirme.odevi.ikys.bussiness.response.EmployerGetAllResponse;
import bitirme.odevi.ikys.bussiness.response.LoginDataEmployerResponse;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.entitites.concretes.Application;
import bitirme.odevi.ikys.entitites.concretes.Employer;
import bitirme.odevi.ikys.entitites.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/employer")
public class EmployerController {

    private final EmployerService employerService;
    private ModelMapperService modelMapperService;
    private JobAdvertisementService jobAdvertisementService;

    @GetMapping("/getall")//methodu list döneceksin
    public List<EmployerGetAllResponse> employerGetAllResponse() {
        return this.employerService.employerGetAllResponse();
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id){
        Optional<Employer> employer = this.employerService.findById(id);
        if (employer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Belirtilen ID'ye sahip işveren bulunamadı.");
        }
        return ResponseEntity.ok(employer);
    }


    @GetMapping("/{employerId}/job-applications")
    public List<JobApplicationDTO> getJobApplicationsByEmployerId(@PathVariable int employerId) {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementService.findByEmployerId(employerId);
        List<JobApplicationDTO> jobApplications = new ArrayList<>();

        for (JobAdvertisement jobAdvertisement : jobAdvertisements) {
            JobApplicationDTO dto = this.modelMapperService.forRequest().map(jobAdvertisement, JobApplicationDTO.class);
            dto.setJobAdvertisementCompanyName(jobAdvertisement.getEmployer().getCompanyName());

            List<ApplicationDto> applicationDTOs = new ArrayList<>();

            for (Application application : jobAdvertisement.getApplications()) {
                ApplicationDto applicationDTO = this.modelMapperService.forRequest().map(application.getJobSeeker(), ApplicationDto.class);
                applicationDTOs.add(applicationDTO);
            }

            dto.setApplications(applicationDTOs);
            jobApplications.add(dto);
        }

        return jobApplications;
    }

    @PostMapping("/save")//http://localhost:8080/api/employer/save
    public ResponseEntity<?> save(@RequestBody EmployerSaveRequest employerSaveRequest) {
        Map<String, Object> map = new LinkedHashMap<>();
        this.employerService.save(employerSaveRequest);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
    @PostMapping("/login")//http://localhost:8080/api/employer/login
    public ResponseEntity<?> loginEmployee(@RequestBody LoginRequest loginRequest){

        LoginDataEmployerResponse response = this.employerService.loginEmployer(loginRequest);
        if (response.isStatus()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


//    @PutMapping("/update/{id}")//http://localhost:8080/api/employer/update/1
//    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Employer employer) {
//        Map<String, Object> map = new LinkedHashMap<>();
//        this.employerService.updateEmployer(id, employer);
//        map.put("message", "Record is Updated Successfully");
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployer(@PathVariable int id, @RequestBody EmployerUpdateRequest updateRequest) {
        this.employerService.updateEmployer(id, updateRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Profil güncellendi.");
    }

}
