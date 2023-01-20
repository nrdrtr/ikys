package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsArayanKontrol;
import bitirme.odevi.ikys.bussiness.abstracts.IsArayanService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.EgitimDao;
import bitirme.odevi.ikys.dataAccess.abstracts.IsArayanDao;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsArayanManager implements IsArayanService {

    private IsArayanDao isArayanDao;
    private final EgitimDao egitimDao;
    private final IsArayanKontrol isArayanKontrol;

    public IsArayanManager(IsArayanDao isArayanDao,EgitimDao egitimDao, IsArayanKontrol isArayanKontrol) {
        this.isArayanDao = isArayanDao;
        this.egitimDao = egitimDao;
        this.isArayanKontrol = isArayanKontrol;
    }


    @Override
    public DataResult<List<IsArayan>> getAllIsArayan() {

        return new SuccessDataResult<>(isArayanDao.findAll(),"Is Arayanlar Listelendi");
    }

    @Override
    public Result save(IsArayan isArayan) {

        if(this.isArayanKontrol.isItEmpty(isArayan)){
            this.isArayanDao.save(isArayan);
            return new SuccessResult(true,"Is Arayan Kaydedildi");
        }
          return new ErrorResult(false,"tüm alanlar doldurulmalıdır");

    }
}
