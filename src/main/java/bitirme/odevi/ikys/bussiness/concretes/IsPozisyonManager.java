package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsPozisyonService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.IsPozisyonDao;
import bitirme.odevi.ikys.entitites.concretes.IsPozisyonu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IsPozisyonManager implements IsPozisyonService {

  private IsPozisyonDao isPozisyonDao;

    @Autowired
    public IsPozisyonManager(IsPozisyonDao isPozisyonDao) {
        this.isPozisyonDao = isPozisyonDao;
    }

    @Override
    public DataResult<List<IsPozisyonu>> getIsPozisyonu() {

        return new SuccessDataResult<>(this.isPozisyonDao.findAll()  , "İş Pozisyonları Listelendi");
    }

    @Override
    public Result addIsPozisyonu(IsPozisyonu isPozisyonu) {
         this.isPozisyonDao.save(isPozisyonu);
        return new SuccessResult(true,"Is Pozisyonu Eklendi");
    }

    @Override
    public Page<IsPozisyonu> findAll(Pageable pageable) {
        return this.isPozisyonDao.findAll(pageable);
    }

    @Override
    public DataResult<IsPozisyonu> findById(int id) {
        return new SuccessDataResult<>( this.isPozisyonDao.findById(id),"İş Pozisyonu Listelendi");
    }

   // @Override
   // public DataResult<List<IsPozisyonu>> findByJobTitleEndsWith(String isIsmi) {
      //  return new SuccessDataResult<>( this.isPozisyonDao.findByJobTitleEndsWith(isIsmi),"İş Pozisyonu adı Listelendi");
    //}
}
