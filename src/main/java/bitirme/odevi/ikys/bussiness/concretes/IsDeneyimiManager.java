package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsDeneyimiService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.IsDeneyimiDao;
import bitirme.odevi.ikys.entitites.concretes.IsDeneyimi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsDeneyimiManager implements IsDeneyimiService {

    private IsDeneyimiDao isDeneyimiDao;
    @Autowired
    public IsDeneyimiManager(IsDeneyimiDao isDeneyimiDao) {
        this.isDeneyimiDao = isDeneyimiDao;
    }

    @Override
    public DataResult<List<IsDeneyimi>> getIsDeneyimiByOzgecmisId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "bitisTarihi");
        if (isDeneyimiDao.getIsDeneyimiBitisTarihiByOzgecmis(id, sort).isEmpty()) {
            return new ErrorDataResult<>("İş Deneyimi Bulunamadı");
        }
        return new SuccessDataResult<List<IsDeneyimi>>
                (this.isDeneyimiDao.getIsDeneyimiBitisTarihiByOzgecmis(id, sort),"İş deneyimleri listelendi (sondan başa doğru tarhi olarak)");



    }


    @Override
    public Result add(IsDeneyimi isDeneyimi) {
     
            return new SuccessDataResult<IsDeneyimi>(isDeneyimi, "İş deneyimi eklendi");
        }

   

    @Override
    public Result delete(int id) {
        this.isDeneyimiDao.deleteById(id);
        return new SuccessResult(true,"İş deneyimi silindi");
    }

    @Override
    public Result update(IsDeneyimi isDeneyimi) {
        return null;
    }
}
