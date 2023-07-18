package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.JobPositionService;
import bitirme.odevi.ikys.bussiness.requests.JobPositionAddRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.JobPosition;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ispozisyonu")
public class JobPositionController {

    private JobPositionService jobPositionService;

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getIsPozisyonu(){
        return this.jobPositionService.getIsPozisyonu();
    }



    @GetMapping("/getBy/{isPozisyonuId}")
    public DataResult<JobPosition> findByIsPozisyonuId(@PathVariable("isPozisyonuId") int id){

       return this.jobPositionService.findById(id);
    }

//    @GetMapping("/pageable")
//    public ResponseEntity<Map<String, Object>> getAllJobPositions(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "3") int size
//    ) {
//        try {
//            Page<JobPosition> jobPositions = this.jobPositionService.getAllJobPositions(page, size);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("jobPositions", jobPositions.getContent());
//            response.put("currentPage", jobPositions.getNumber());
//            response.put("totalPages", jobPositions.getTotalPages());
//
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
    @GetMapping("/api/job-positions")
    public ResponseEntity<Page<JobPosition>> getJobPositions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<JobPosition> jobPositions = jobPositionService.getJobPositions(page, size);
        return ResponseEntity.ok(jobPositions);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addJobPosition(@RequestBody JobPositionAddRequest positionAddRequest   ){
        Map<String, Object> map = new LinkedHashMap<>();
        this.jobPositionService.save(positionAddRequest);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
