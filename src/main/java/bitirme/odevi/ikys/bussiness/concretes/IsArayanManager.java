package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsArayanService;
import bitirme.odevi.ikys.bussiness.rules.UserBussinessRules;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.EgitimDao;
import bitirme.odevi.ikys.dataAccess.abstracts.IsArayanDao;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IsArayanManager implements IsArayanService {

    private IsArayanDao isArayanDao;
    private EgitimDao egitimDao;
    private UserBussinessRules userBussinessRules;

    @Override
    public DataResult<List<IsArayan>> getAllIsArayan() {

        return new SuccessDataResult<>(isArayanDao.findAll(), "Is Arayanlar Listelendi");
    }

    @Override
    public Result save(IsArayan isArayan) {
        this.userBussinessRules.jobSeekerRegistrationCheck(isArayan);
        this.userBussinessRules.isEmailExist(isArayan.getEPosta());
        this.userBussinessRules.isKimlikNumarasiExist(isArayan.getKimlikNumarasi());
        this.userBussinessRules.isMailValidator(isArayan);

        isArayanDao.save(isArayan);
        return new SuccessResult("Is Arayan Kaydedildi");
    }


    @Override
    public Result deleteIsArayanById(int id) {
        this.isArayanDao.deleteIsArayanById(id);
        return new SuccessResult("Is Arayan Silindi");
    }
}
