package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.dataAccess.abstracts.IsArayanDao;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
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
    private IsArayanDao isArayanDao;


    @GetMapping("/verify")
    public IsArayan verify(@RequestParam Long token) {
        IsArayan isArayan = isArayanDao.getIsArayanById(token.intValue());
        isArayan.setAktifMi(true);
        return isArayanDao.save(isArayan);

    }

}