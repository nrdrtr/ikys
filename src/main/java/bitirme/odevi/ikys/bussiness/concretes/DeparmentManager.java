package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.DeparmentService;
import bitirme.odevi.ikys.bussiness.rules.DepartmentBussinessRules;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.DepartmentDao;
import bitirme.odevi.ikys.entitites.concretes.Department;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeparmentManager implements DeparmentService {

    private DepartmentDao departmentDao;
    private DepartmentBussinessRules departmentBusinessRules;


    @Override
    public DataResult<List<Department>> getAll() {
       this.departmentBusinessRules.isEmptyBolum();
        return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(), "Bölümler başarıyla listelendi!");
    }

    @Override
    public Result add(Department department) {
        this.departmentDao.save(department);
        return new SuccessResult("Bölüm başarıyla eklendi!");
    }
}
