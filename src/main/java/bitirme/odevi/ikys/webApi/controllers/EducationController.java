package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.EducationService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.EducationRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Education;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/education")
public class EducationController {

    private EducationService educationService;

    @GetMapping("/getall")//http://localhost:8080/api/egitim/getall
    public DataResult<List<Education>> getall() {
        return this.educationService.egitimGetAll();
    }

    @PostMapping("/save")
    public Result save(@RequestBody EducationRequest educationRequest) {
        return this.educationService.save(educationRequest);
    }


    @PostMapping("/update")
    public Result update(@RequestBody Education school) {
        return this.educationService.update(school);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.educationService. deleteEgitimById(id);
    }

    @GetMapping("/getById")
    public DataResult<Education> getById(@RequestParam int id){
        return this.educationService.getById(id);
    }


    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll(){
        return this.educationService.egitimGetAll();
    }

    @GetMapping("/findAllByEmployeeIdOrderBySchoolGraduationDateDesc")
    DataResult<List<Education>> findAllByEmployeeIdOrderBySchoolGraduationDateDesc(@RequestParam int employeeId){
        return this.educationService.findAllByJobSeekerIdOrderByEndDateDesc (employeeId);
    }





}
