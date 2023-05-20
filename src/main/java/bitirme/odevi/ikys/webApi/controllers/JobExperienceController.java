package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.JobExperienceService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/isdeneyimi")

public class JobExperienceController {

    private JobExperienceService workExperienceService;

    @GetMapping("/getIsDeneyimiByOzgecmisId")
    DataResult<List<bitirme.odevi.ikys.entitites.concretes.JobExperience>> getIsDeneyimiByOzgecmisId(@RequestParam int id){
        return  this.workExperienceService.getIsDeneyimiByOzgecmisId(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody bitirme.odevi.ikys.entitites.concretes.JobExperience jobExperience){
        return  this.workExperienceService.add(jobExperience);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
         return this.workExperienceService.delete(id);
    }



}
