package bitirme.odevi.ikys.bussiness.rules;

import bitirme.odevi.ikys.core.utilities.exceptions.BusinessException;
import bitirme.odevi.ikys.dataAccess.abstracts.EgitimDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EducationBussinessRules {

    private EgitimDao egitimDao;

    public void isEmptyEducation() {
        if (this.egitimDao.findAll().isEmpty()) {
            throw new BusinessException("Eğitim bulunamadı");
        }
    }

    public void sortByEndDate(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "bitisTarihi");
        if (this.egitimDao.getEgitimBitisTarihiByOzgecmisId(id, sort).isEmpty()) {
            throw new BusinessException("Eğitim bulunamadı");
        } else {
            this.egitimDao.getEgitimBitisTarihiByOzgecmisId(id, sort);
        }
    }
}
