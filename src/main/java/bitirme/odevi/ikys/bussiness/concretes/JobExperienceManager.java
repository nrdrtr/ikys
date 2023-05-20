package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.JobExperienceService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.JobExperienceDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;

    @Override
    public DataResult<List<bitirme.odevi.ikys.entitites.concretes.JobExperience>> getIsDeneyimiByOzgecmisId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "bitisTarihi");
        if (jobExperienceDao.getJobExperienceByCurriculumVitae(id, sort).isEmpty()) {
            return new ErrorDataResult<>("İş Deneyimi Bulunamadı");
        }
        return new SuccessDataResult<List<bitirme.odevi.ikys.entitites.concretes.JobExperience>>
                (this.jobExperienceDao.getJobExperienceByCurriculumVitae(id, sort), "İş deneyimleri listelendi (sondan başa doğru tarhi olarak)");


    }


    @Override
    public Result add(bitirme.odevi.ikys.entitites.concretes.JobExperience jobExperience) {

        return new SuccessDataResult<bitirme.odevi.ikys.entitites.concretes.JobExperience>(jobExperience, "İş deneyimi eklendi");
    }


    @Override
    public Result delete(int id) {
        this.jobExperienceDao.deleteById(id);
        this.jobExperienceDao.deleteJobExperienceById(id);
        return new SuccessResult(true, "İş deneyimi silindi");
    }

}
