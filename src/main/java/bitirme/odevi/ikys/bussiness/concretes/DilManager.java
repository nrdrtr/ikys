package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.DilService;
import bitirme.odevi.ikys.bussiness.rules.LanguageBussinessRules;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.DilDao;
import bitirme.odevi.ikys.entitites.concretes.Dil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DilManager implements DilService {
    private DilDao dillerDao;
    private LanguageBussinessRules languageBussinessRules;


    @Override
    public DataResult<List<Dil>> getDiller() {

        this.languageBussinessRules.isEmptyLanguage();
        return new SuccessDataResult<>(this.dillerDao.findAll(), "Yabancı diller başarıyla listelendi!");

    }

    @Override
    public DataResult<List<Dil>> add(List<Dil> diller) {
        return new SuccessDataResult<>(this.dillerDao.saveAll(diller), "Yabancı dil ekleme işlemi başarılı!");
    }


}