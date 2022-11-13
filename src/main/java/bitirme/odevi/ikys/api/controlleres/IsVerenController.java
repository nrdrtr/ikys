package bitirme.odevi.ikys.api.controlleres;

import bitirme.odevi.ikys.bussiness.abstracts.IsVerenService;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/isveren")
@RestController
public class IsVerenController {

    private IsVerenService isVerenService;

    @Autowired
    public IsVerenController(IsVerenService isVerenService) {
        this.isVerenService = isVerenService;
    }

    @GetMapping("/getall")//methodu list döneceksin
    public List<IsVeren> getIsVeren() {
       return this.isVerenService.isVeren();
    }


    @PostMapping("/save")
    public void save(@RequestBody  IsVeren isVeren){
        this.isVerenService.save(isVeren);
    }
}
