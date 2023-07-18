package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.WorkType;

import java.util.List;

public interface WorkTypeService {
    DataResult<List<WorkType>>  getAll() throws Exception;
    DataResult<WorkType> add(WorkType workType) throws Exception;

}
