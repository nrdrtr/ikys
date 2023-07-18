package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.JobExperienceRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {

    Result add(JobExperienceRequest JobExperienceRequest);
    Result update(JobExperience jobExperience);
    Result delete(int id);
    DataResult<JobExperience> getById(int id);
    DataResult<List<JobExperience>> getAll();
    DataResult<List<JobExperience>> findAllByJobSeekerIdOrderByEndDateDesc(int jobSeekerId);


}
