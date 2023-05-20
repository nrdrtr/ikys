package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.SchoolService;
import bitirme.odevi.ikys.bussiness.response.School.GetAllResponseSchools;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/okullar")
public class SchoolController {

    private SchoolService schoolService;
    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        List<GetAllResponseSchools> schools = this.schoolService.getAll();
        return ResponseEntity.ok().body(schools);
    }

}