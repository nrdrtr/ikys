package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.ApplicationService;
import bitirme.odevi.ikys.bussiness.requests.JobSeekerAdvertApplicationRequest;
import bitirme.odevi.ikys.bussiness.response.JobAdvertisementDTO;
import bitirme.odevi.ikys.core.utilities.exceptions.ResourceNotFoundException;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.dataAccess.abstracts.ApplicationDao;
import bitirme.odevi.ikys.dataAccess.abstracts.JobAdvertisementDao;
import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerDao;
import bitirme.odevi.ikys.entitites.concretes.Application;
import bitirme.odevi.ikys.entitites.concretes.JobAdvertisement;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {

    private final ApplicationDao applicationDao;
    private final ModelMapperService modelMapperService;
    private final JobAdvertisementDao jobAdvertisementRepository;
    private final JobSeekerDao jobSeekerRepository;


    @Override
    public List<JobAdvertisementDTO> getAllByJobSeekerId(int jobSeekerId) {
        List<Application> applications = applicationDao.findAllByJobSeekerId(jobSeekerId);

        List<JobAdvertisementDTO> advertisementDTOList = new ArrayList<>();
        for (Application application : applications) {
            JobAdvertisement jobAdvertisement = application.getJobAdvertisement();

            JobAdvertisementDTO advertisementDTO = modelMapperService.forRequest().map(jobAdvertisement, JobAdvertisementDTO.class);
           // advertisementDTO.setEmployerName(jobAdvertisement.getEmployer().getCompanyName());
          advertisementDTO.setJobPositionTitle(jobAdvertisement.getJobPosition().getJobName());
            //     advertisementDTO.setCityName(jobAdvertisement.getCity().getCityName());
            advertisementDTO.setStatus(application.getStatus());

            advertisementDTOList.add(advertisementDTO);
        }

        return advertisementDTOList;
    }

    @Override
    public List<Application> getApplicationsByJobAdvertisementId(int jobAdvertisementId) {
        return this.applicationDao.findByJobAdvertisementId(jobAdvertisementId);
    }

    public List<Application> getApplicationsByEmployerId(int employerId) {
        return this.applicationDao.findByJobAdvertisement_Employer_Id(employerId);
    }

    @Override
    public void createApplication(JobSeekerAdvertApplicationRequest jobSeekerAdvertApplicationRequest) {
        int jobAdvertisementId = jobSeekerAdvertApplicationRequest.getJobAdvertisementId();
        int jobSeekerId = jobSeekerAdvertApplicationRequest.getJobSeekerId();

        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(jobAdvertisementId);
        JobSeeker jobSeeker = jobSeekerRepository.getJobSeekerById(jobSeekerId);

        if (jobAdvertisement == null || jobSeeker == null) {
            throw new IllegalArgumentException("İlan veya iş arayan bulunamadı");
        }

        Application application = modelMapperService.forRequest().map(jobSeekerAdvertApplicationRequest, Application.class);
        application.setJobAdvertisement(jobAdvertisement);
        application.setJobSeeker(jobSeeker);
        application.setStatus("pending");

        applicationDao.save(application);
    }



    @Override
    public void deleteApplication(int applicationId) {
         this.applicationDao.deleteById(applicationId);
    }

    @Override
    public void rejectApplication(int applicationId) {
        Optional<Application> application = this.applicationDao.findById(applicationId);
        if (application.isPresent()) {
            application.get().setStatus("rejected");
            applicationDao.save(application.get());
        } else {
            throw new IllegalArgumentException("Başvuru bulunamadı");
        }
    }

    @Override
    public void approveApplication(int applicationId) throws ResourceNotFoundException{
        Optional<Application> applicationOptional = applicationDao.findById(applicationId);
        if (applicationOptional.isPresent()) {

            applicationOptional.get().setStatus("approved");
            applicationDao.save(applicationOptional.get());
        } else {
            throw new ResourceNotFoundException("Başvuru bulunamadı");
        }
    }


}
