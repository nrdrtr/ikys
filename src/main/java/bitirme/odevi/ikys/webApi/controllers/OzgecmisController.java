package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.OzgecmisService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Ozgecmis;
import bitirme.odevi.ikys.entitites.dto.OzgecmisAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/ozgecmis")
@RestController
@CrossOrigin
public class OzgecmisController {

    private OzgecmisService ozgecmisService;

    @Autowired
    public OzgecmisController(OzgecmisService ozgecmisService) {
        this.ozgecmisService = ozgecmisService;
    }


    @GetMapping("/getCvWithJobSeekerId")
    public DataResult<Ozgecmis> findCvByJobSeekerId(int jobseekerId) {
        return this.ozgecmisService.findByJobSeekerId(jobseekerId);
    }

    @PostMapping("/addCv")
    public Result addCv(@RequestBody OzgecmisAddDto ozgecmis) {
        return this.ozgecmisService.addOzgecmis(ozgecmis);
    }

    @PutMapping("/updateCv")
    public Result updateCv(@RequestBody OzgecmisAddDto ozgecmis) {
        return this.ozgecmisService.updateOzgecmis(ozgecmis);
    }


    @PostMapping("/addPicture/{cvId}")
    public ResponseEntity<Result> addPicture(@PathVariable int cvId, @RequestParam("file") MultipartFile file) throws IOException {

        Result result = this.ozgecmisService.uploadPicture(cvId, file);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

