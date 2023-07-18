package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.SocialMediaRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobSeekerSocialMedia;

import java.util.List;

public interface JobSeekerSocialMediaService {
    Result add(JobSeekerSocialMedia jobSeekerSocialMedia);
    Result save (SocialMediaRequest socialMediaRequest);
    Result update(JobSeekerSocialMedia jobSeekerSocialMedia);
    Result delete(int id);
    DataResult<JobSeekerSocialMedia> getById(int id);
    DataResult<List<JobSeekerSocialMedia>> getAll();
    DataResult<List<JobSeekerSocialMedia>> getAllByJobSeekerId(int jobSeekerId);
}
