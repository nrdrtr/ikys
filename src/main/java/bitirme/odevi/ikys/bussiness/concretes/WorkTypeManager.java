package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.WorkTypeService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.WorkTypeDao;
import bitirme.odevi.ikys.entitites.concretes.WorkType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkTypeManager implements WorkTypeService {

    private WorkTypeDao workTypeDao;

    @Override
    public DataResult<List<WorkType>> getAll() throws Exception {
        // TODO Auto-generated method stub
        return new SuccessDataResult<>(this.workTypeDao.findAll(),"Çalışma tipi listlendi");
    }

    @Override
    public DataResult<WorkType> add(WorkType entity) throws Exception {

        WorkType workType=this.workTypeDao.save(entity);
        return new SuccessDataResult<WorkType>(workType,"Çalışma tipi eklendi");
    }

}