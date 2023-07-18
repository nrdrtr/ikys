package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerService;
import bitirme.odevi.ikys.bussiness.requests.authRequests.JobSeekerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.authRequests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.JobSeekerResponse;
import bitirme.odevi.ikys.bussiness.response.LoginDataJobSeekerResponse;
import bitirme.odevi.ikys.bussiness.rules.UserBussinessRules;
import bitirme.odevi.ikys.core.mail.EmailService;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerDao;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobseekerDao;
    private UserBussinessRules userBussinessRules;
    private ModelMapperService modelMapperService;
    private PasswordEncoder passwordEncoder;
    private EmailService emailService;

    @Override
    public DataResult<List<JobSeeker>> getAllIsArayan() {

        return new SuccessDataResult<>(jobseekerDao.findAll(), "Is Arayanlar Listelendi");
    }

    @Override
    public List<JobSeekerResponse> getAllJobSeeker() {


        List<JobSeeker> jobSeekers = jobseekerDao.findAll();

        return jobSeekers.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, JobSeekerResponse.class))
                .collect(Collectors.toList());


    }

    @Override
    public Optional<JobSeeker> findById(int id) {
        return this.jobseekerDao.findById(id);
    }

    @Override
    public LoginDataJobSeekerResponse loginJobSeeker(LoginRequest loginRequest) {
        String msg = "Login Failed";
        JobSeeker seeker = this.jobseekerDao.findByEmail(loginRequest.getEmail());

        if (seeker != null && !seeker.isVerified()) {
            return new LoginDataJobSeekerResponse("Kullanıcı aktif değil", false, null);
        }

        if (seeker != null) {
            String password = loginRequest.getPassword();
            String encodedPassword = seeker.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {
                Optional<JobSeeker> jobSeeker = this.jobseekerDao.findOneByEmailAndPassword(loginRequest.getEmail(), encodedPassword);

                if (jobSeeker.isPresent()) {
                    return new LoginDataJobSeekerResponse("Giriş Başarılı", true, jobSeeker.get());
                } else {
                    return new LoginDataJobSeekerResponse(msg, false, null);
                }
            } else {
                return new LoginDataJobSeekerResponse("Şifre Eşleşmiyor", false, null);
            }
        } else {
            return new LoginDataJobSeekerResponse("Bu maile sahip bir iş arayan yoktur", false, null);
        }
    }

    @Override
    public JobSeekerResponse loginJobSeeker2(LoginRequest loginRequest) {
        String msg = "Login Failed";
        JobSeeker seeker = this.jobseekerDao.findByEmail(loginRequest.getEmail());

        if (seeker != null && !seeker.isVerified()) {
            return new JobSeekerResponse(0, "Kullanıcı aktif değil", false, null, null, null, null, null, null);
        }

        if (seeker != null) {
            String password = loginRequest.getPassword();
            String encodedPassword = seeker.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {
                Optional<JobSeeker> jobSeeker = this.jobseekerDao.findOneByEmailAndPassword(loginRequest.getEmail(), encodedPassword);

                if (jobSeeker.isPresent()) {
                    return new JobSeekerResponse(jobSeeker.get().getId(), "Giriş Başarılı", true, jobSeeker.get().getName(), jobSeeker.get().getSurname(), jobSeeker.get().getEmail(), jobSeeker.get().getIdentityNumber(), jobSeeker.get().getBirthDate(), jobSeeker.get().getCurriculumVitaes());
                } else {
                    return new JobSeekerResponse(0, msg, false, null, null, null, null, null, null);
                }
            } else {
                return new JobSeekerResponse(0, "Şifre Eşleşmiyor", false, null, null, null, null, null, null);
            }
        } else {
            return new JobSeekerResponse(0, "Bu maile sahip bir iş arayan yoktur", false, null, null, null, null, null, null);
        }
    }


    @Override
    public Result save(JobSeekerSaveRequest jobseekerSaveRequest) {

        JobSeeker jobseeker = this.modelMapperService.forRequest().map(jobseekerSaveRequest, JobSeeker.class);
        String encodedPassword = this.passwordEncoder.encode(jobseekerSaveRequest.getPassword());
        String encodedPasswordAgain = this.passwordEncoder.encode(jobseekerSaveRequest.getPasswordAgain());
        jobseeker.setPassword(encodedPassword);
        jobseeker.setPasswordAgain(encodedPasswordAgain);
        jobseeker.setUserType("jobseeker");
        jobseeker.setVerified(false);

        this.userBussinessRules.jobSeekerRegistrationCheck(jobseeker);
        this.userBussinessRules.isEmailExist(jobseeker.getEmail());
        this.userBussinessRules.identityNumberCheck(jobseeker.getIdentityNumber());
        this.userBussinessRules.checkPasswordsMatch(jobseekerSaveRequest.getPassword(), jobseekerSaveRequest.getPasswordAgain());
        this.userBussinessRules.isMailValidatorJobSeeker(jobseeker);

        this.jobseekerDao.save(jobseeker);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(jobseekerSaveRequest.getEmail());
        mailMessage.setSubject("Kaydını Tamamla!");
        mailMessage.setText("Hesabınızı onaylamak için lütfen burayı tıklayın : "
                + " http://localhost:8080/api/verification/verify-jobSeeker?id=" + jobseeker.getId());

        this.emailService.sendEmail(mailMessage);
        return new SuccessResult("Is Arayan Kaydedildi");
    }


    @Override
    public void deleteJobSeeker(int id) {
        this.jobseekerDao.findById(id).map(user -> {
            this.jobseekerDao.delete(user);
            return ResponseEntity.ok("User deleted successfully!");
        }).orElseThrow(() -> new RuntimeException("Error: User not found!"));
    }


}