package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerLanguageService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.JobseekerLanguagesRequest;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerLanguagesDao;
import bitirme.odevi.ikys.entitites.concretes.JobseekerLanguages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobSeekerLanguagesManager implements JobSeekerLanguageService {

    private JobSeekerLanguagesDao jobSeekerLanguagesDao;
    private ModelMapperService modelMapperService;



    @Override
    public Result add(JobseekerLanguagesRequest jobseekerLanguagesRequest) {
        JobseekerLanguages jobseekerLanguages = modelMapperService.forRequest().map(jobseekerLanguagesRequest, JobseekerLanguages.class);
        this.jobSeekerLanguagesDao.save(jobseekerLanguages);
        return new SuccessResult("Dil bilgisi eklendi");
    }

    @Override
    public Result update(JobseekerLanguages jobseekerLanguages) {
        JobseekerLanguages updatedEmployeeLanguage = this.jobSeekerLanguagesDao.getById(jobseekerLanguages.getId());
        updatedEmployeeLanguage.setLanguage(jobseekerLanguages.getLanguage());
        updatedEmployeeLanguage.setLanguageLevel(jobseekerLanguages.getLanguageLevel());
        this.jobSeekerLanguagesDao.save(updatedEmployeeLanguage);
        return new SuccessResult("Dil bilgisi güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.jobSeekerLanguagesDao.deleteById(id);
        return new SuccessResult("Dil bilgisi silindi");
    }

    @Override
    public DataResult<JobseekerLanguages> getById(int id) {
        return new SuccessDataResult<>(this.jobSeekerLanguagesDao.findById(id).orElse(null));
    }

    @Override
    public DataResult<List<JobseekerLanguages>> getAll() {
        return new SuccessDataResult<List<JobseekerLanguages>>(this.jobSeekerLanguagesDao.findAll());
    }

    @Override
    public DataResult<List<JobseekerLanguages>> getAllByJobSeekerId(int employeeId) {
        return new SuccessDataResult<List<JobseekerLanguages>>(this.jobSeekerLanguagesDao.findAllByJobSeekerId(employeeId));
    }

}
