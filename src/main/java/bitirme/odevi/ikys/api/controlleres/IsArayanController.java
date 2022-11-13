package bitirme.odevi.ikys.api.controlleres;

import bitirme.odevi.ikys.bussiness.abstracts.IIsArayanService;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isarayan")
public class IsArayanController {

    private IIsArayanService isArayanService;

    @Autowired
    public IsArayanController(IIsArayanService isArayanService) {
        super();
        this.isArayanService = isArayanService;
    }

    @GetMapping("/getall")
    public List<IsArayan> getIsArayan(){
        return this.isArayanService.getIsArayan();
    }

    @PostMapping("/save")
    public void save( @RequestBody IsArayan isArayan){
        this.isArayanService.save(isArayan);
    }
}
