package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.CityService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.ErrorDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.SehirDao;
import bitirme.odevi.ikys.entitites.concretes.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityManager implements CityService {

    private final SehirDao sehirDao;


    @Override
    public DataResult<List<City>> getAll() {
        if ((long) this.sehirDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.sehirDao.findAll(), "Success: Şehirler başarıyla listelendi!");
        }

        return new ErrorDataResult<>(this.sehirDao.findAll(), "Error: Şehirler listelenemedi!");
    }


}
