package bitirme.odevi.ikys.bussiness.rules;

import bitirme.odevi.ikys.core.utilities.exceptions.BusinessException;
import bitirme.odevi.ikys.dataAccess.abstracts.LanguageDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LanguageBussinessRules {

    private LanguageDao languageDao;
    public void isEmptyLanguage() {
        if (this.languageDao.findAll().isEmpty()) {
            throw new BusinessException("Dil bulunamadı");
        }
    }

}
