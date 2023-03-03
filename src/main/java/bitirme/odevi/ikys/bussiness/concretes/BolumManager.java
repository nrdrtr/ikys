package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.BolumService;
import bitirme.odevi.ikys.bussiness.rules.DepartmentBussinessRules;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.BolumDao;
import bitirme.odevi.ikys.entitites.concretes.Bolum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BolumManager implements BolumService {
    private BolumDao bolumDao;
    private DepartmentBussinessRules departmentBusinessRules;


    @Override
    public DataResult<List<Bolum>> getAll() {
       this.departmentBusinessRules.isEmptyBolum();
        return new SuccessDataResult<List<Bolum>>(this.bolumDao.findAll(), "Bölümler başarıyla listelendi!");
    }

    @Override
    public Result add(Bolum bolum) {
        this.bolumDao.save(bolum);
        return new SuccessResult("Bölüm başarıyla eklendi!");
    }
}
