package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Resim;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ResimService {
    Result add(Resim resim);

    DataResult<List<Resim>> getAll();

    DataResult<Resim> getById(int id);

    DataResult<Resim> getByUserId(int userId);

    Result delete(int id);

    Result upload(int kullaniciId, MultipartFile file);

    Result update(Resim resim);

}
