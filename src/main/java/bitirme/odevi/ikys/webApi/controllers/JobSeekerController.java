package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerService;
import bitirme.odevi.ikys.bussiness.requests.JobSeekerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.LoginMessage;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/api/isarayan")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

   // private EmailManager emailManager;

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getIsArayan() {
        return this.jobSeekerService.getAllIsArayan();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody JobSeekerSaveRequest jobSeekerSaveRequest)   {
        Map<String, Object> map = new LinkedHashMap<>();
        this.jobSeekerService.save(jobSeekerSaveRequest);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);//201
    }
    @PostMapping("/login")//http://localhost:8080/api/jobSeeker/login
    public ResponseEntity<?> loginJobSeeker(@RequestBody LoginRequest loginRequest){

        LoginMessage loginMessage = this.jobSeekerService.loginJobSeeker(loginRequest);
        return ResponseEntity.ok(loginMessage);
    }



    @DeleteMapping("/delete")
    public void deleteIsArayanById(@RequestParam int id) {
        this.jobSeekerService.deleteIsArayanById(id);
    }


}





