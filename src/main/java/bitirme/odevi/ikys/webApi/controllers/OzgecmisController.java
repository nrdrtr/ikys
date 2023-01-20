package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.OzgecmisService;
import bitirme.odevi.ikys.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/ozgecmis")
@RestController
public class OzgecmisController {

    private OzgecmisService ozgecmisService;

    @Autowired
    public OzgecmisController(OzgecmisService ozgecmisService) {
        this.ozgecmisService = ozgecmisService;
    }


//    @PostMapping("/addPicture")
//    public Result addPicture(CurriculaVitaeAddDto curriculaVitae) throws IOException {
//        return this.ozgecmisService.addCv(curriculaVitae);
//    }
}

