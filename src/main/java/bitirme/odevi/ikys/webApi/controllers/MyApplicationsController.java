package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.ApplicationService;
import bitirme.odevi.ikys.bussiness.response.JobAdvertisementDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class MyApplicationsController {

    private final ApplicationService applicationService;

    @GetMapping("/getBy/{jobSeekerId}")
    public ResponseEntity<List<JobAdvertisementDTO>> getAppliedAdvertisementsForJobSeeker(@RequestParam int jobSeekerId) {
        List<JobAdvertisementDTO> advertisementDTOList = applicationService. getAllByJobSeekerId(jobSeekerId);
        return ResponseEntity.ok(advertisementDTOList);
    }
    @DeleteMapping("/cancel/{applicationId}")//http://localhost:8080/api/applications/cancel/1
    public ResponseEntity<String> cancelApplication(@PathVariable int applicationId) {
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.ok("Başvuru iptal edildi");
    }


}
