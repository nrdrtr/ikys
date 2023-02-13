package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.IsDeneyimiService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsDeneyimi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isdeneyimi")
@CrossOrigin
public class IsDeneyimiController {
    IsDeneyimiService isDeneyimiService;
    @Autowired
    public IsDeneyimiController(IsDeneyimiService isDeneyimiService) {
        this.isDeneyimiService = isDeneyimiService;
    }


    @GetMapping("/getIsDeneyimiByOzgecmisId")
    DataResult<List<IsDeneyimi>> getIsDeneyimiByOzgecmisId(@RequestParam int id){
        return  this.isDeneyimiService.getIsDeneyimiByOzgecmisId(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody IsDeneyimi isDeneyimi){
        return  this.isDeneyimiService.add(isDeneyimi);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
         return this.isDeneyimiService.delete(id);
    }



}
