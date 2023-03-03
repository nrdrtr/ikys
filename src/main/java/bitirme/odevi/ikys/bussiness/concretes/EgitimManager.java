package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.EgitimService;
import bitirme.odevi.ikys.bussiness.rules.EducationBussinessRules;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.EgitimDao;
import bitirme.odevi.ikys.entitites.concretes.Egitim;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EgitimManager implements EgitimService {

    private EgitimDao egitimDao;
    private EducationBussinessRules educationBussinessRules;


    @Override
    public DataResult<List<Egitim>> egitimGetEgitimByOzgecmisId(int id) {
        this.educationBussinessRules.sortByEndDate(id);
        return new SuccessDataResult<>("Eğitim geçmişi başarıyla sıralanıp listelendi!");
    }


    @Override
    public DataResult<List<Egitim>> egitimGetAll() {
        this.educationBussinessRules.isEmptyEducation();
        return new SuccessDataResult<>(this.egitimDao.findAll(), "Success: Tüm eğitim bilgileri başarıyla listelendi!");
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
