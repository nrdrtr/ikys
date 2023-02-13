package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsArayanService;
import bitirme.odevi.ikys.bussiness.abstracts.KayıtKontrol;
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
    private final KayıtKontrol kayıtKontrol;


    public IsArayanManager(IsArayanDao isArayanDao, EgitimDao egitimDao, KayıtKontrol kayıtKontrol) {
        this.isArayanDao = isArayanDao;
        this.egitimDao = egitimDao;
        this.kayıtKontrol = kayıtKontrol;

    }


    @Override
    public DataResult<List<IsArayan>> getAllIsArayan() {

        return new SuccessDataResult<>(isArayanDao.findAll(), "Is Arayanlar Listelendi");
    }

    @Override
    public Result save(IsArayan isArayan) {
        if (isArayan.getAdi().isEmpty() || isArayan.getSoyadi().isEmpty() || isArayan.getKimlikNumarasi().isEmpty() || isArayan.getDogumTarihi() == null || isArayan.getEPosta().isEmpty() || isArayan.getSifre().isEmpty() || isArayan.getSifreTekrari().isEmpty()) {

            return new ErrorResult(false, "Tüm alanlar zorunludur. Lütfen tekrar deneyin.");
        } else {
            isArayanDao.save(isArayan);
            return new SuccessResult("Is Arayan Kaydedildi");
        }


    }

    @Override
    public Result deleteIsArayanById(int id) {
        this.isArayanDao.deleteIsArayanById(id);
        return new SuccessResult("Is Arayan Silindi");
    }
}
