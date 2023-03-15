package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.IsArayanService;
//import bitirme.odevi.ikys.bussiness.concretes.EmailManager;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/api/isarayan")
@CrossOrigin
@AllArgsConstructor
public class IsArayanController {

    private IsArayanService isArayanService;

   // private EmailManager emailManager;

    @GetMapping("/getall")
    public DataResult<List<IsArayan>> getIsArayan() {
        return this.isArayanService.getAllIsArayan();
    }

    @PostMapping("/save")
    public Result save(@RequestBody IsArayan isArayan) throws MessagingException, FileNotFoundException {
        isArayan.setAktifMi(false);
        return this.isArayanService.save(isArayan);
    }

    @DeleteMapping("/delete")
    public void deleteIsArayanById(@RequestParam int id) {
        this.isArayanService.deleteIsArayanById(id);
    }


}





