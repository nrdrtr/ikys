package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.EducationService;
import bitirme.odevi.ikys.bussiness.rules.EducationBussinessRules;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.EducationDao;
import bitirme.odevi.ikys.entitites.concretes.Education;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EducationManager implements EducationService {

    private EducationDao educationDao;
    private EducationBussinessRules educationBussinessRules;


    @Override
    public DataResult<List<Education>> egitimGetEgitimByOzgecmisId(int id) {
        this.educationBussinessRules.sortByEndDate(id);
        return new SuccessDataResult<>("Eğitim geçmişi başarıyla sıralanıp listelendi!");
    }


    @Override
    public DataResult<List<Education>> egitimGetAll() {
        this.educationBussinessRules.isEmptyEducation();
        return new SuccessDataResult<>(this.educationDao.findAll(), "Success: Tüm eğitim bilgileri başarıyla listelendi!");
    }

    @Override
    public Result save(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Success: Eğitim bilgileri başarıyla eklendi!");
    }

    @Override
    public Result deleteEgitimById(int id) {
        this.educationDao.deleteById(id);
        return new SuccessResult("Success: Eğitim bilgisi silindi!");
    }


}
