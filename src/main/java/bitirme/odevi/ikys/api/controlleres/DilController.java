package bitirme.odevi.ikys.api.controlleres;

import bitirme.odevi.ikys.bussiness.abstracts.IDillerService;
import bitirme.odevi.ikys.entitites.concretes.Diller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/diller")
public class DilController {

    private IDillerService  dillerService;

    @Autowired
    public DilController(IDillerService dillerService) {
        super();
        this.dillerService = dillerService;
    }

    @GetMapping("/getall")
    public List<Diller> getDiller(){

        return this.dillerService.getDiller();
    }



}
