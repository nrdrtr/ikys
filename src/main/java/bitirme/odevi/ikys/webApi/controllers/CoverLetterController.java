package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.CoverLetterService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.CoverLetterAddRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.CoverLetter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/coverletters")
public class CoverLetterController {

    private CoverLetterService coverLetterService;


    @PostMapping("/add")
    public Result add(@RequestBody CoverLetterAddRequest coverLetter) {
        return this.coverLetterService.add(coverLetter);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CoverLetter coverLetter ) {
        return this.coverLetterService.update(coverLetter);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.coverLetterService.delete(id);
    }



    @GetMapping("/getById")
    public DataResult<CoverLetter> getById(@RequestParam int id){
        return this.coverLetterService.getById(id);
    }

    @GetMapping("/getAllByEmployeeId")
    public DataResult<List<CoverLetter>> getAllByEmployeeId(@RequestParam int employeeId){
        return this.coverLetterService.getAllByJobSeekerId(employeeId);
    }


    @GetMapping("/getAll")
    public DataResult<List<CoverLetter>> getAll(){
        return this.coverLetterService.getAll();
    }

}