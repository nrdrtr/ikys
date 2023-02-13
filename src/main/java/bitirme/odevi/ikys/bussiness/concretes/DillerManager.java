package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IDillerService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.ErrorDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.DilDao;
import bitirme.odevi.ikys.entitites.concretes.Dil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DillerManager implements IDillerService {
    private DilDao dillerDao;

    @Autowired
    public DillerManager(DilDao dillerDao) {
        super();
        this.dillerDao = dillerDao;
    }

    @Override
    public DataResult<List<Dil>> getDiller() {

        if (this.dillerDao.findAll().isEmpty()) {
            return new ErrorDataResult<>("Warning: Kayıtlı yabancı dil bulunamadı!");
        }
        return new SuccessDataResult<>(this.dillerDao.findAll(), "Success: Yabancı diller başarıyla listelendi!");

    }

    @Override
    public DataResult<List<Dil>> add(List<Dil> diller) {
        return new SuccessDataResult<>(this.dillerDao.saveAll(diller), "Success: Yabancı dil ekleme işlemi başarılı!");
    }


}
