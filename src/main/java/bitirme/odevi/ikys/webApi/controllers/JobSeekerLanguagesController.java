package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerLanguageService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.JobseekerLanguagesRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobseekerLanguages;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employeelanguages")
public class JobSeekerLanguagesController {


    private JobSeekerLanguageService jobSeekerLanguageService;

    @PostMapping("/add")
    public Result add(@RequestBody JobseekerLanguagesRequest jobseekerLanguagesRequest) {
        return this.jobSeekerLanguageService.add(jobseekerLanguagesRequest);
    }

    @PostMapping("/update")//hatalı
    public Result update(@RequestBody JobseekerLanguages employeeLanguage) {
        return this.jobSeekerLanguageService.update(employeeLanguage);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.jobSeekerLanguageService.delete(id);
    }

    @GetMapping("/getById")
    public DataResult<JobseekerLanguages> getById(@RequestParam int id){
        return this.jobSeekerLanguageService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobseekerLanguages>> getAll(){
        return this.jobSeekerLanguageService.getAll();
    }

    @GetMapping("/getAllByEmployeeId")
    DataResult<List<JobseekerLanguages>> getAllByEmployeeId(@RequestParam int employeeId){
        return this.jobSeekerLanguageService.getAllByJobSeekerId(employeeId);
    }
}
