package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.IsPozisyonService;
import bitirme.odevi.ikys.entitites.concretes.IsPozisyonu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ispozisyonu")
public class IsPozisyonController{

    private IsPozisyonService isPozisyonService;

    @Autowired
    public IsPozisyonController(IsPozisyonService isPozisyonService) {
        this.isPozisyonService = isPozisyonService;
    }

    @GetMapping("/getall")
    public List<IsPozisyonu> getIsPozisyonu(){
        return this.isPozisyonService.getIsPozisyonu();
    }
}
