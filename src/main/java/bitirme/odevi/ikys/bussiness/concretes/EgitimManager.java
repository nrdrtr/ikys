package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.EgitimService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.EgitimDao;
import bitirme.odevi.ikys.entitites.concretes.Egitim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EgitimManager implements EgitimService {

    private EgitimDao egitimDao;

    @Autowired
    public EgitimManager(EgitimDao egitimDao) {
        this.egitimDao = egitimDao;
    }


    @Override
    public DataResult<List<Egitim>> egitimGetEgitimByOzgecmisId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "bitisTarihi");
        if (this.egitimDao.getEgitimBitisTarihiByOzgecmisId(id, sort).isEmpty()) {
            return new ErrorDataResult<>("Listelenecek eğitim bilgisi bulunamadı!");
        } else {
            return new SuccessDataResult<>(this.egitimDao.getEgitimBitisTarihiByOzgecmisId(id, sort), "Success: Eğitim geçmişi başarıyla sıralanıp listelendi!");
        }
    }

    @Override
    public DataResult<List<Egitim>> egitimGetAll() {
        if (this.egitimDao.findAll().isEmpty()) {
            return new ErrorDataResult<>("Warning: Listelenecek bir eğitim bilgisi bulunamadı!");
        } else {
            return new SuccessDataResult<>(this.egitimDao.findAll(), "Success: Tüm eğitim bilgileri başarıyla listelendi!");
        }
    }


    @Override
    public Result save(Egitim egitim) {
        this.egitimDao.save(egitim);
        return new SuccessResult("Success: Eğitim bilgileri başarıyla eklendi!");
    }

    @Override
    public Result deleteEgitimById(int id) {
        this.egitimDao.deleteById(id);
        return new SuccessResult("Success: Eğitim bilgisi silindi!");
    }


}
