package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.LanguageService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.Language;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/diller")
public class LanguageController {

    private LanguageService dillerService;

    @GetMapping("/getall")
    public DataResult<List<Language>> getDiller(){
        return this.dillerService.getDiller();
    }

    @GetMapping("/getByDilAdi")//yanlış DÜZELECEK
    public DataResult<List<Language>> getDilAdi (@RequestBody List<Language> diller){
        return this.dillerService.add(diller);
    }





}
