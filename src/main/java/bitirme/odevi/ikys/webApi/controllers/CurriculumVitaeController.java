package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.CurriculumVitaeService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.CurriculumVitae;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/resumes")
public class CurriculumVitaeController {

    private CurriculumVitaeService curriculumVitaeService;

    @GetMapping("/getCvWithJobSeekerId")
    public DataResult<CurriculumVitae> findCvByJobSeekerId(int jobseekerId) {
        return this.curriculumVitaeService.getByJobSeekerId(jobseekerId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody CurriculumVitae curriculumVitae) {
        return this.curriculumVitaeService.add(curriculumVitae);
    }


    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.curriculumVitaeService.delete(id);
    }


    @GetMapping("/getall")
    public DataResult<List<CurriculumVitae>> getAll() {
        return this.curriculumVitaeService.getAll();
    }

    @GetMapping("/getByEmployeeId")
    DataResult<CurriculumVitae> getByEmployeeId(@RequestParam int employeeId) {
        return this.curriculumVitaeService.getByJobSeekerId(employeeId);
    }

    //    @PutMapping("/update")
//    public Result update(@RequestBody CurriculumVitae resume) {
//        return this.curriculumVitaeService.update(resume);
//    }
    //    @GetMapping("/getById")
//    public DataResult<CurriculumVitae> getById(@RequestParam int id){
//        return this.curriculumVitaeService.getById(id);
//    }


//    @PostMapping("/addPicture/{cvId}")
//    public ResponseEntity<Result> addPicture(@PathVariable int cvId, @RequestParam("file") MultipartFile file) throws IOException {
//
//        Result result = this.curriculumVitaeService.uploadPicture(cvId, file);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

}

