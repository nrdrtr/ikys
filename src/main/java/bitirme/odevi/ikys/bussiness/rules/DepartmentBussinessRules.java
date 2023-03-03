package bitirme.odevi.ikys.bussiness.rules;

import bitirme.odevi.ikys.core.utilities.exceptions.BusinessException;
import bitirme.odevi.ikys.dataAccess.abstracts.BolumDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentBussinessRules {
    private BolumDao bolumDao;

    public void isEmptyBolum() {
        if (this.bolumDao.findAll().isEmpty()) {
            throw new BusinessException("Bolum bulunamadı");
        }

    }

}

