package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.SkillService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.SkillAddRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        super();
        this.skillService = skillService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody SkillAddRequest request) {
        return this.skillService.add(request);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Skill skill) {
        return this.skillService.update(skill);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.skillService.delete(id);
    }

    @GetMapping("/getById")
    public DataResult<Skill> getById(@RequestParam int id){
        return this.skillService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Skill>> getAll(){
        return this.skillService.getAll();
    }

    @GetMapping("/getAllByEmployeeId")
    DataResult<List<Skill>> getAllByEmployeeId(@RequestParam int employeeId){
        return this.skillService.getAllByJobSeekerId(employeeId);
    }
}