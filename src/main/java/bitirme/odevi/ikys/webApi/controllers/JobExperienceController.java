package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.JobExperienceService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.JobExperienceRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobExperience;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/jobexperiences")

public class JobExperienceController {

    private JobExperienceService jobExperienceService;


    @PostMapping("/add")
    public Result add(@RequestBody JobExperienceRequest request) {
        return this.jobExperienceService.add(request);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobExperience jobExperience){
        return this.jobExperienceService.update(jobExperience);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.jobExperienceService.delete(id);
    }

    @GetMapping("/getById")
    public DataResult<JobExperience> getById(@RequestParam int id){
        return this.jobExperienceService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobExperience>> getAll(){
        return this.jobExperienceService.getAll();
    }

    @GetMapping("/findAllByEmployeeIdOrderByJobLeaveDateDesc")
    DataResult<List<JobExperience>> findAllByEmployeeIdOrderByJobLeaveDateDesc(@RequestParam int employeeId){
        return this.jobExperienceService.findAllByJobSeekerIdOrderByEndDateDesc(employeeId);
    }



}
