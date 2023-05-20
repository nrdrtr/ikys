package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.bussiness.abstracts.ImageService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Image;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/resimler")
public class ImageController {

    private ImageService resimService;

    @PostMapping()
    @RequestMapping(value = "/upload/{kullaniciId}",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result upload(@RequestParam(value = "kullaniciId") int kullaniciId, @RequestParam MultipartFile file) {
        return resimService.upload(kullaniciId, file);

    }

    @GetMapping("/getAll")
    public DataResult<List<Image>> getAll() {
        return resimService.getAll();
    }

    @GetMapping("/getByUserId")
    public DataResult<Image> getByUserId(@RequestParam int userId) {
        return resimService.getByUserId(userId);
    }

    @GetMapping("/getById")
    public DataResult<Image> getById(@RequestParam int id) {
        return resimService.getById(id);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return resimService.delete(id);
    }


}
