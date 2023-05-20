package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.JobPositionService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.JobPositionDao;
import bitirme.odevi.ikys.entitites.concretes.JobPosition;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;
  
    @Override
    public DataResult<List<JobPosition>> getIsPozisyonu() {

        return new SuccessDataResult<>(this.jobPositionDao.findAll()  , "İş Pozisyonları Listelendi");
    }

//    @Override
//    public List<JobPosition> getAllJobPositions(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
//        return jobPositionDao.findAll(pageable).getContent();
//    }

    @Override
    public Result addIsPozisyonu(JobPosition jobPosition) {
         this.jobPositionDao.save(jobPosition);
        return new SuccessResult(true,"Is Pozisyonu Eklendi");
    }

    @Override
    public Page<JobPosition> getJobPositions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return jobPositionDao.findAll(pageable);
    }

    @Override
    public DataResult<JobPosition> findById(int id) {
        return new SuccessDataResult<>( this.jobPositionDao.findById(id),"İş Pozisyonu Listelendi");
    }

   // @Override
   // public DataResult<List<JobPosition>> findByJobTitleEndsWith(String isIsmi) {
      //  return new SuccessDataResult<>( this.jobPositionDao.findByJobTitleEndsWith(isIsmi),"İş Pozisyonu adı Listelendi");
    //}
}
