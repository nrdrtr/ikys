package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.JobSeekerAdvertApplicationRequest;
import bitirme.odevi.ikys.bussiness.response.JobAdvertisementDTO;
import bitirme.odevi.ikys.core.utilities.exceptions.ResourceNotFoundException;
import bitirme.odevi.ikys.entitites.concretes.Application;

import java.util.List;

public interface ApplicationService {

    List<JobAdvertisementDTO> getAllByJobSeekerId(int jobSeekerId);

    List<Application> getApplicationsByJobAdvertisementId(int jobAdvertisementId);

    List<Application> getApplicationsByEmployerId(int employerId);

    void createApplication(JobSeekerAdvertApplicationRequest jobSeekerAdvertApplicationRequest);
    void deleteApplication(int applicationId);
    void rejectApplication(int applicationId);
    void approveApplication(int applicationId) throws ResourceNotFoundException;

}
