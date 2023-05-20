package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ImageService {
    Result add(Image image);

    DataResult<List<Image>> getAll();

    DataResult<Image> getById(int id);

    DataResult<Image> getByUserId(int userId);

    Result delete(int id);

    Result upload(int kullaniciId, MultipartFile file);

    Result update(Image image);

}
