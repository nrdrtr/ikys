package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.JobseekerLanguagesRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobseekerLanguages;

import java.util.List;

public interface JobSeekerLanguageService {

    Result add(JobseekerLanguagesRequest jobseekerLanguagesRequest);
    Result update(JobseekerLanguages employeeLanguage);
    Result delete(int id);
    DataResult<JobseekerLanguages> getById(int id);
    DataResult<List<JobseekerLanguages>> getAll();
    DataResult<List<JobseekerLanguages>> getAllByJobSeekerId(int employeeId);
}