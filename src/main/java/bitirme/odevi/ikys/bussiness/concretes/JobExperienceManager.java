package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.JobExperienceService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.JobExperienceRequest;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.JobExperienceDao;
import bitirme.odevi.ikys.entitites.concretes.JobExperience;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;
    private ModelMapperService modelMapperService;

    @Override
    public Result add(JobExperienceRequest JobExperienceRequest) {

        JobExperience jobExperience = this.modelMapperService.forRequest().map(JobExperienceRequest, JobExperience.class);
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("İş tecrübesi eklendi.");
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
    }

    @Override
    public DataResult<List<JobExperience>> findAllByJobSeekerIdOrderByEndDateDesc(int employeeId) {
        return new SuccessDataResult<>(this.jobExperienceDao.findAllByJobSeekerIdOrderByEndDateDesc(employeeId));
    }

    @Override
    public Result update(JobExperience jobExperience) {
        JobExperience updJobExperience = this.jobExperienceDao.getById(jobExperience.getId());

        updJobExperience.setPositionName(jobExperience.getPositionName());
        updJobExperience.setCompanyName(jobExperience.getCompanyName());
        updJobExperience.setStartDate(jobExperience. getStartDate());
        updJobExperience.setEndDate(jobExperience. getEndDate());

        this.jobExperienceDao.save(updJobExperience);
        return new SuccessResult("İş tecrübesi güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.jobExperienceDao.deleteById(id);
        return new SuccessResult("İş tecrübesi silindi");
    }

    @Override
    public DataResult<JobExperience> getById(int id) {
        return new SuccessDataResult<JobExperience>(this.jobExperienceDao.findById(id).orElse(null));
    }
}
