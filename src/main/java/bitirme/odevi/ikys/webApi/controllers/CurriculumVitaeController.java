package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.CurriculumVitaeService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.CurriculumVitae;
import bitirme.odevi.ikys.entitites.dto.OzgecmisAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/ozgecmis")
public class CurriculumVitaeController {

    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }


    @GetMapping("/getCvWithJobSeekerId")
    public DataResult<CurriculumVitae> findCvByJobSeekerId(int jobseekerId) {
        return this.curriculumVitaeService.findByJobSeekerId(jobseekerId);
    }

    @PostMapping("/addCv")
    public Result addCv(@RequestBody OzgecmisAddDto ozgecmis) {
        return this.curriculumVitaeService.addOzgecmis(ozgecmis);
    }


    @PutMapping("/updateCv")
    public Result updateCv(@RequestBody OzgecmisAddDto ozgecmis) {
        return this.curriculumVitaeService.updateOzgecmis(ozgecmis);
    }


    @PostMapping("/addPicture/{cvId}")
    public ResponseEntity<Result> addPicture(@PathVariable int cvId, @RequestParam("file") MultipartFile file) throws IOException {

        Result result = this.curriculumVitaeService.uploadPicture(cvId, file);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

