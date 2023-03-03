package bitirme.odevi.ikys.bussiness.rules;

import bitirme.odevi.ikys.core.utilities.exceptions.BusinessException;
import bitirme.odevi.ikys.dataAccess.abstracts.DilDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LanguageBussinessRules {

    private DilDao dilDao;
    public void isEmptyLanguage() {
        if (this.dilDao.findAll().isEmpty()) {
            throw new BusinessException("Dil bulunamadı");
        }
    }

}
