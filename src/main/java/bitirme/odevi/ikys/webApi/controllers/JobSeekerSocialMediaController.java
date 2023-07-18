package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerSocialMediaService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.SocialMediaRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobSeekerSocialMedia;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@AllArgsConstructor
@RequestMapping("/api/employeesocialmedias")
public class JobSeekerSocialMediaController {

    private final JobSeekerSocialMediaService employeeSocialMediaService;


    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerSocialMedia employeeSocialMedia) {
        return this.employeeSocialMediaService.add(employeeSocialMedia);
    }

    @PostMapping("/save")
    public Result save(@RequestBody SocialMediaRequest socialMediaRequest) {
        return this.employeeSocialMediaService.save(socialMediaRequest);
    }


    @GetMapping("/getAll")
    public DataResult<List<JobSeekerSocialMedia>> getAll(){
        return this.employeeSocialMediaService.getAll();
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobSeekerSocialMedia employeeSocialMedia ) {
        return this.employeeSocialMediaService.update(employeeSocialMedia);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.employeeSocialMediaService.delete(id);
    }

    @GetMapping("/getById")
    public DataResult<JobSeekerSocialMedia> getById(@RequestParam int id){
        return this.employeeSocialMediaService.getById(id);
    }

    @GetMapping("/getAllByEmployeeId")
    DataResult<List<JobSeekerSocialMedia>> getAllByEmployeeId(@RequestParam int employeeId){
        return this.employeeSocialMediaService.getAllByJobSeekerId(employeeId);
    }
}
