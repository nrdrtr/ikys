package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Department;

import java.util.List;

public interface DeparmentService {
    DataResult<List<Department >> getAll();
    Result add(Department department);
}
 