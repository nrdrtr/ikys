package bitirme.odevi.ikys.bussiness.concretes;


import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.dataAccess.abstracts.CurriculumVitaeDao;
import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobSeekerCVService {

    private   JobSeekerDao jobSeekerRepository;
    private   CurriculumVitaeDao curriculumVitaeRepository;
    private ModelMapperService modelMapperService;

//    public CurriculumVitae addCurriculumVitae(JobSeekerCvAddRequest request) {
//
//        JobSeeker jobSeeker = jobSeekerRepository.findById(request.getJobSeekerId()).get();
//        CurriculumVitae curriculumVitae = modelMapperService.forRequest().map(request, CurriculumVitae.class);
//        curriculumVitae.setJobSeeker(jobSeeker);
//        return curriculumVitaeRepository.save(curriculumVitae);
//
//
//
//
//    }
}
