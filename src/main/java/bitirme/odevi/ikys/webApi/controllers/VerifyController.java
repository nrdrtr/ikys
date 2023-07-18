package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.dataAccess.abstracts.EmployerDao;
import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerDao;
import bitirme.odevi.ikys.entitites.concretes.Employer;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/verification")
@AllArgsConstructor
public class VerifyController {


    private JobSeekerDao jobseekerDao;
    private EmployerDao employerDao;
    //userDao'da kullanılabilir.


    @GetMapping("/verify-jobSeeker")//http://localhost:8080/api/verification/verify-jobSeeker?id=34
    public ResponseEntity<?> verifyJobSeeker(@RequestParam int id) {//linke tıklanınca aktiflik durumu true olacak ve response olarak kayıdınız tamanlandı dönecek

        Map<String, Object> map = new LinkedHashMap<>();
        JobSeeker jobSeeker = jobseekerDao.getJobSeekerById(id);
        jobSeeker.setVerified(true);
        jobseekerDao.save(jobSeeker);
        map.put("message", "Doğrulama tamamlandı!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);//201
    }
//    @GetMapping("/verify-jobSeeker")
//    public ModelAndView verifyJobSeeker(@RequestParam int id) {
//        JobSeeker jobSeeker = jobseekerDao.getJobSeekerById(id);
//        jobSeeker.setVerified(true);
//        jobseekerDao.save(jobSeeker);
//        ModelAndView modelAndView = new ModelAndView("verification-complete");
//        modelAndView.addObject("message", "Doğrulama tamamlandı!");
//        return modelAndView;
//    }

    @GetMapping("/verify-employer")//http://localhost:8080/api/verification/verify-employer?id=?
    public ResponseEntity<?> verifyEmployer(@RequestParam int id) {

        Map<String, Object> map = new LinkedHashMap<>();
        Employer employer = employerDao.getEmployerById(id);
        employer.setVerified(true);
        employerDao.save(employer);
        map.put("message", "Doğrulama tamamlandı!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);//201
    }

}