package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.bussiness.requests.authRequests.JobSeekerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.authRequests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.JobSeekerResponse;
import bitirme.odevi.ikys.bussiness.response.LoginDataJobSeekerResponse;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;

import java.util.List;
import java.util.Optional;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getAllIsArayan();


    List<JobSeekerResponse> getAllJobSeeker();

    Optional<JobSeeker> findById(int id);

    Result save(JobSeekerSaveRequest jobseekerSaveRequest);


    void deleteJobSeeker(int id);

    LoginDataJobSeekerResponse loginJobSeeker(LoginRequest loginRequest);
    JobSeekerResponse loginJobSeeker2(LoginRequest loginRequest);


}
