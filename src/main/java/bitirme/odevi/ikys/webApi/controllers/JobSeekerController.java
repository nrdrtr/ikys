package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerService;
import bitirme.odevi.ikys.bussiness.requests.authRequests.JobSeekerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.authRequests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.JobSeekerResponse;
import bitirme.odevi.ikys.bussiness.response.LoginDataJobSeekerResponse;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/isarayan")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;


    @GetMapping("/getall")//http://localhost:8080/api/isarayan/getall
    public DataResult<List<JobSeeker>> getIsArayan() {
        return this.jobSeekerService.getAllIsArayan();
    }
    @GetMapping("/getalljobseekers")//http://localhost:8080/api/isarayan/getall
    public  List<JobSeekerResponse > getAllJobSeeker() {
        return this.jobSeekerService.getAllJobSeeker();
    }

    @GetMapping("/getById/{id}")//http://localhost:8080/api/isarayan/getById/6
    public ResponseEntity<?> findById(@PathVariable("id") int id){
        Optional<JobSeeker> jobSeeker = this.jobSeekerService.findById(id);
        if (jobSeeker.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Belirtilen ID'ye sahip iş arayan bulunamadı.");
        }
        return ResponseEntity.ok(jobSeeker);
    }



    @PostMapping("/save")//http://localhost:8080/api/isarayan/save
    public ResponseEntity<?> save(@RequestBody JobSeekerSaveRequest jobSeekerSaveRequest)   {
        Map<String, Object> map = new LinkedHashMap<>();
        this.jobSeekerService.save(jobSeekerSaveRequest);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);//201
    }


    @PostMapping("/login")//http://localhost:8080/api/isarayan/login
    public ResponseEntity<?> loginJobSeeker(@RequestBody LoginRequest loginRequest){

        LoginDataJobSeekerResponse response = this.jobSeekerService.loginJobSeeker(loginRequest);
        if (response.isStatus()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @PostMapping("/login2")//http://localhost:8080/api/isarayan/login
    public ResponseEntity<?> loginJobSeeker2(@RequestBody LoginRequest loginRequest){

        JobSeekerResponse response = this.jobSeekerService.loginJobSeeker2(loginRequest);
        if ( response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }




    @DeleteMapping("/delete")
    public void deleteIsArayanById(@RequestParam int id) {
        this.jobSeekerService.deleteJobSeeker(id);
    }


}





