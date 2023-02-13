package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.SehirService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.ErrorDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.SehirDao;
import bitirme.odevi.ikys.entitites.concretes.Sehir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SehirManager implements SehirService {

    private final SehirDao sehirDao;

    @Autowired
    public SehirManager(SehirDao sehirDao) {
        this.sehirDao = sehirDao;
    }

    @Override
    public DataResult<List<Sehir>> getAll() {
        if ((long) this.sehirDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.sehirDao.findAll(), "Success: Şehirler başarıyla listelendi!");
        }

        return new ErrorDataResult<>(this.sehirDao.findAll(),"Error: Şehirler listelenemedi!") ;
    }


}
