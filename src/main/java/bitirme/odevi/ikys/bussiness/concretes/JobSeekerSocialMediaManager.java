package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerSocialMediaService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.SocialMediaRequest;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.EmployeeSocialMediaDao;
import bitirme.odevi.ikys.entitites.concretes.JobSeekerSocialMedia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobSeekerSocialMediaManager implements JobSeekerSocialMediaService {
    private EmployeeSocialMediaDao employeeSocialMediaDao;
    private ModelMapperService modelMapperService;



    @Override
    public Result add(JobSeekerSocialMedia employeeSocialMedia) {
        this.employeeSocialMediaDao.save(employeeSocialMedia);
        return new SuccessResult("Kullanıcı sosyal medya bilgisi eklendi");
    }

    @Override
    public Result save(SocialMediaRequest socialMediaRequest) {
        JobSeekerSocialMedia jobSeekerSocialMedia = modelMapperService.forRequest().map(socialMediaRequest, JobSeekerSocialMedia.class);
        this.employeeSocialMediaDao.save(jobSeekerSocialMedia);

         return new SuccessResult("Sosyal medya bilgisi eklendi");
    }

    @Override
    public DataResult<List<JobSeekerSocialMedia>> getAll() {
        return new SuccessDataResult<List<JobSeekerSocialMedia>>(this.employeeSocialMediaDao.findAll());
    }

    @Override
    public DataResult<List<JobSeekerSocialMedia>> getAllByJobSeekerId(int employeeId) {
        return new SuccessDataResult<>(this.employeeSocialMediaDao.findAllByJobSeekerId(employeeId));
    }

    @Override
    public Result update(JobSeekerSocialMedia employeeSocialMedia) {
        JobSeekerSocialMedia updEmployeeSocialMedia = this.employeeSocialMediaDao.getById(employeeSocialMedia.getId());
        updEmployeeSocialMedia.setSocialMedia(employeeSocialMedia.getSocialMedia());
        updEmployeeSocialMedia.setSocialMediaAdress(employeeSocialMedia.getSocialMediaAdress());
        this.employeeSocialMediaDao.save(updEmployeeSocialMedia);
        return new SuccessResult("Sosyal medya bilgisi güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.employeeSocialMediaDao.deleteById(id);
        return new SuccessResult("Sosyal medya bilgisi silindi");
    }

    @Override
    public DataResult<JobSeekerSocialMedia> getById(int id) {
        return new SuccessDataResult<JobSeekerSocialMedia>(this.employeeSocialMediaDao.findById(id).orElse(null));
    }



}
