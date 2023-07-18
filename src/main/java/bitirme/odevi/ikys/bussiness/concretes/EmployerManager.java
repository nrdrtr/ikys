package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.EmployerService;
import bitirme.odevi.ikys.bussiness.requests.authRequests.EmployerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.EmployerUpdateRequest;
import bitirme.odevi.ikys.bussiness.requests.authRequests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.EmployerGetAllResponse;
import bitirme.odevi.ikys.bussiness.response.LoginDataEmployerResponse;
import bitirme.odevi.ikys.bussiness.rules.UserBussinessRules;
import bitirme.odevi.ikys.core.mail.EmailService;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.EmployerDao;
import bitirme.odevi.ikys.entitites.concretes.Employer;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private PasswordEncoder passwordEncoder;
    private UserBussinessRules userBussinessRules;
    private ModelMapperService modelMapperService;
    private EmailService emailService;


    @Override
    public List<EmployerGetAllResponse> employerGetAllResponse() {

        List<Employer> employers = employerDao.findAll();
        return employers.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, EmployerGetAllResponse.class))
                .collect(Collectors.toList());
    }


    @Override
    public Result save(EmployerSaveRequest employerSaveRequest) {

        Employer employer = this.modelMapperService.forRequest().map(employerSaveRequest, Employer.class);
        String encodedPassword = this.passwordEncoder.encode(employerSaveRequest.getPassword());
        String encodedPasswordAgain = this.passwordEncoder.encode(employerSaveRequest.getPasswordAgain());
        employer.setPassword(encodedPassword);
        employer.setPasswordAgain(encodedPasswordAgain);
        employer.setUserType("employer");
        employer.setVerified(false);

        this.userBussinessRules.employerRegistrationCheck(employer);
        this.userBussinessRules.companyNameCheck(employer.getCompanyName());
        this.userBussinessRules.isEmailExist(employer.getEmail());
        this.userBussinessRules.isWebSiteExist(employer.getWebsite());
        this.userBussinessRules.isMailValidatorIsveren(employer);
        this.userBussinessRules.checkPasswordsMatch(employerSaveRequest.getPassword(), employerSaveRequest.getPasswordAgain());

        this.employerDao.save(employer);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(employerSaveRequest.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + " http://localhost:8080/api/verification/verify-employer?id=" + employer.getId());

        this.emailService.sendEmail(mailMessage);
        return new SuccessResult("Isveren   Kaydedildi");

    }

    @Override
    public Optional<Employer> findById(int id) {
        return this.employerDao.findById(id);
    }



    @Override//giriş
    public LoginDataEmployerResponse loginEmployer(LoginRequest loginRequest) {
        String msg = "Login Failed";
        Employer employer = this.employerDao.findByEmail(loginRequest.getEmail());

        if (employer != null && !employer.isVerified()) { //eğer kullanıcı aktif değilse login olamaz
            return new LoginDataEmployerResponse("Kullanıcı aktif değil", false,null);
        }

        if (employer != null) {
            String password = loginRequest.getPassword();
            String encodedPassword = employer.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employer> employer1 = this.employerDao.findOneByEmailAndPassword(loginRequest.getEmail(), encodedPassword);
                if (employer1.isPresent()) {
                    return new LoginDataEmployerResponse("Login Success", true,employer1.get());
                } else {
                    return new LoginDataEmployerResponse(msg, false,null);
                }
            } else {

                return new LoginDataEmployerResponse("password Not Match", false,null);
            }
        } else {
            return new LoginDataEmployerResponse("bu maile sahip bir employer yoktur", false,null);
        }

    }
    @Override
    public void updateEmployer(int employerId, EmployerUpdateRequest updateRequest) {
        Employer existingEmployer = employerDao.findById(employerId).orElse(null);
        if (existingEmployer != null) {
            existingEmployer.setEmail(updateRequest.getEmail());
            existingEmployer.setCompanyName(updateRequest.getCompanyName());
            existingEmployer.setWebsite(updateRequest.getWebsite());
            existingEmployer.setPhoneNumber(updateRequest.getPhoneNumber());

            employerDao.save(existingEmployer);
        }
    }

    @Override
    public Result uploadPicture(int isverenId, MultipartFile file) throws IOException {
//        var result = this.cloudinaryService.addPicture(file);
//        var url = result.getData().get("url");
//
//        Employer ref = this.employerDao.getOne(isverenId);
//        ref.setResimUrl(url.toString());
//        this.employerDao.save(ref);

        return new SuccessResult("Success: Resim ekleme işlemi başarılı!");
    }


}
