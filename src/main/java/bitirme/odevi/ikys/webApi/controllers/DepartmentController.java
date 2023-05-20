package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.DeparmentService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Department;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bolumler")
public class DepartmentController {

    private DeparmentService deparmentService;

    @GetMapping("/getall")
    public DataResult<List<Department>> getAll() {
        return this.deparmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
        return this.deparmentService.add(department);
    }
}
