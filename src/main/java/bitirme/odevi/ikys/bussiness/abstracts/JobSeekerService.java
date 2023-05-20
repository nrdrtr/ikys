package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.bussiness.requests.JobSeekerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.LoginMessage;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getAllIsArayan();

    Result save(JobSeekerSaveRequest jobseekerSaveRequest);
    //Result save(JobSeeker jobseeker);

  //  DataResult<IsArayan> findByePosta(String ePosta);
    Result deleteIsArayanById(int id);

    LoginMessage loginJobSeeker(LoginRequest loginRequest);

}
