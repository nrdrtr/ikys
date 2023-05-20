package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.EmployerService;
import bitirme.odevi.ikys.bussiness.requests.EmployerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.LoginMessage;
import bitirme.odevi.ikys.entitites.concretes.Employer;
import bitirme.odevi.ikys.entitites.dto.EmployerWithJobAdvertisementDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



@RestController
@AllArgsConstructor
@RequestMapping("/api/employer")
public class EmployerController {

    private final EmployerService employerService;

    @GetMapping("/getall")//methodu list döneceksin
    public List<Employer> getIsVeren() {
       return this.employerService.isVeren();
    }


    @PostMapping("/save")//http://localhost:8080/api/employer/save
    public ResponseEntity<?> saveUser(@RequestBody EmployerSaveRequest employerSaveRequest) {
        Map<String, Object> map = new LinkedHashMap<>();
        this.employerService.save(employerSaveRequest);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
    @PostMapping("/login")//http://localhost:8080/api/employer/login
    public ResponseEntity<?> loginEmployee(@RequestBody LoginRequest loginRequest){

        LoginMessage loginMessage = this.employerService.loginEmployer(loginRequest);
        return ResponseEntity.ok(loginMessage);
    }


    @GetMapping("/getIsverenWithIsIlanıDetails")
    public List<EmployerWithJobAdvertisementDto> getIsverenWithIsIlanıDetails(){
        return this.employerService.getIsverenWithIsIlanıDetails();
    }


}
