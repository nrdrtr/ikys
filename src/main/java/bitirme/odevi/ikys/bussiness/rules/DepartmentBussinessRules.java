package bitirme.odevi.ikys.bussiness.rules;

import bitirme.odevi.ikys.core.utilities.exceptions.BusinessException;
import bitirme.odevi.ikys.dataAccess.abstracts.DepartmentDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentBussinessRules {

    private DepartmentDao departmentDao;

    public void isEmptyBolum() {
        if (this.departmentDao.findAll().isEmpty()) {
            throw new BusinessException("Bolum bulunamadı");
        }

    }

}

