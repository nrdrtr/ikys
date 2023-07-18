package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.WorkTypeService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.WorkType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/worktypes")
public class WorkTypeController{

    private WorkTypeService workTypeService;


    @GetMapping("/getall")
    public DataResult<List<WorkType>> getAll() throws Exception {
         return   this.workTypeService.getAll();
     }
    @PostMapping("/add")
    public DataResult<WorkType> add(@RequestBody WorkType workType) throws Exception {
         return this.workTypeService.add(workType);
    }
}