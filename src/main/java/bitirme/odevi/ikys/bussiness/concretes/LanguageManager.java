package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.LanguageService;
import bitirme.odevi.ikys.bussiness.rules.LanguageBussinessRules;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.LanguageDao;
import bitirme.odevi.ikys.entitites.concretes.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {
    private LanguageDao dillerDao;
    private LanguageBussinessRules languageBussinessRules;


    @Override
    public DataResult<List<Language>> getDiller() {

        this.languageBussinessRules.isEmptyLanguage();
        return new SuccessDataResult<>(this.dillerDao.findAll(), "Yabancı diller başarıyla listelendi!");

    }

    @Override
    public DataResult<List<Language>> add(List<Language> diller) {
        return new SuccessDataResult<>(this.dillerDao.saveAll(diller), "Yabancı dil ekleme işlemi başarılı!");
    }


}