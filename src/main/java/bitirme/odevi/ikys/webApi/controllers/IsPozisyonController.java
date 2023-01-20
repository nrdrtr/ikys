package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.IsPozisyonService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.entitites.concretes.IsPozisyonu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ispozisyonu")
@CrossOrigin
public class IsPozisyonController{

    private IsPozisyonService isPozisyonService;

    @Autowired
    public IsPozisyonController(IsPozisyonService isPozisyonService) {
        this.isPozisyonService = isPozisyonService;
    }

    @GetMapping("/getall")
    public DataResult<List<IsPozisyonu>> getIsPozisyonu(){
        return this.isPozisyonService.getIsPozisyonu();
    }


    @GetMapping("/getBy{isPozisyonuId}")
    public DataResult<IsPozisyonu> findByIsPozisyonuId(int id){

       return this.isPozisyonService.findById(id);
    }
   /* @GetMapping("/getByfindByJobTitleEndsWith{jobTitle}")
    public DataResult<List<IsPozisyonu>> findByJobTitleEndsWith(String isIsmi){

        return  this.isPozisyonService.findByJobTitleEndsWith(isIsmi);
    }*/

    @GetMapping("/pageable")
    public ResponseEntity<Map<String, Object>> getAllPageable(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "3") int size) {

        try {
            List<IsPozisyonu> tutorials = new ArrayList<IsPozisyonu>();

            Pageable paging = PageRequest.of(page, size);
            //Pageable pagingSort = PageRequest.of(page, size, Sort.by("id").descending());
            Page<IsPozisyonu> pageTuts = this.isPozisyonService.findAll(paging);

            tutorials = pageTuts.getContent();


            Map<String, Object> response = new HashMap<>();
            response.put("tutorials", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/add")
    public Result addIsPoziyonu(IsPozisyonu isPozisyonu){
        return this.isPozisyonService.addIsPozisyonu(isPozisyonu);
    }
}
