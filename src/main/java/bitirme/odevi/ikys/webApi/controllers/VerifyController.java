package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerDao;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verification")
@AllArgsConstructor
public class VerifyController {
    @Autowired
    private JobSeekerDao jobseekerDao;


    @GetMapping("/verify")
    public JobSeeker verify(@RequestParam Long token) {
        JobSeeker jobseeker = jobseekerDao.getJobSeekerById(token.intValue());
      //  jobseeker.setActive(true);
        return jobseekerDao.save(jobseeker);

    }

}