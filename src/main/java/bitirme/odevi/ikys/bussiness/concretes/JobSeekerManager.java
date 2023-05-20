package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerService;
import bitirme.odevi.ikys.bussiness.requests.JobSeekerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.LoginMessage;
import bitirme.odevi.ikys.bussiness.rules.UserBussinessRules;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerDao;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobseekerDao;
    private UserBussinessRules userBussinessRules;
    private ModelMapperService modelMapperService;
    private PasswordEncoder passwordEncoder;

    @Override
    public DataResult<List<JobSeeker>> getAllIsArayan() {

        return new SuccessDataResult<>(jobseekerDao.findAll(), "Is Arayanlar Listelendi");
    }

    @Override
    public LoginMessage loginJobSeeker(LoginRequest loginRequest) {
        String msg = "Login Failed";
        JobSeeker employer = this.jobseekerDao.findByEmail(loginRequest.getEmail());
        if (employer != null) {
            String password = loginRequest.getPassword();
            String encodedPassword = employer.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<JobSeeker> jobSeeker = this.jobseekerDao.findOneByEmailAndPassword(loginRequest.getEmail(), encodedPassword);
                if (jobSeeker.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage( msg, false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("bu maile sahip bir jobSeeker yoktur", false);
        }

    }

    @Override
    public Result save(JobSeekerSaveRequest jobseekerSaveRequest) {

        JobSeeker jobseeker = this.modelMapperService.forRequest().map(jobseekerSaveRequest, JobSeeker.class);
        String encodedPassword = this.passwordEncoder.encode(jobseeker.getPassword());
        jobseeker.setPassword(encodedPassword);
        jobseeker.setPasswordAgain(encodedPassword);
        jobseeker.setUserType("jobseeker");

        this.userBussinessRules.jobSeekerRegistrationCheck(jobseeker);
        this.userBussinessRules.isEmailExist(jobseeker.getEmail());
        this.userBussinessRules.isIdentityNumberExist(jobseeker.getIdentityNumber());
        this.userBussinessRules.isMailValidatorIsArayan(jobseeker);

        jobseekerDao.save(jobseeker);

        return new SuccessResult("Is Arayan Kaydedildi");
    }



    @Override
    public Result deleteIsArayanById(int id) {
        this.jobseekerDao.deleteJobSeekerById(id);
        return new SuccessResult("Is Arayan Silindi");
    }
}
