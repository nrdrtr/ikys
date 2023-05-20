package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.EmployerService;
import bitirme.odevi.ikys.bussiness.requests.EmployerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.LoginMessage;
import bitirme.odevi.ikys.bussiness.rules.UserBussinessRules;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.EmployerDao;
import bitirme.odevi.ikys.entitites.concretes.Employer;
import bitirme.odevi.ikys.entitites.dto.EmployerWithJobAdvertisementDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private PasswordEncoder passwordEncoder;
    private UserBussinessRules userBussinessRules;
    private ModelMapperService modelMapperService;



    @Override
    public List<Employer> isVeren() {
        return this.employerDao.findAll();
    }

    @Override
    public void save(EmployerSaveRequest employerSaveRequest) {

        Employer employer = this.modelMapperService.forRequest().map(employerSaveRequest, Employer.class);
        String encodedPassword = this.passwordEncoder.encode(employerSaveRequest.getPassword());
        employer.setPassword(encodedPassword);
        employer.setPasswordAgain(encodedPassword);
        employer.setUserType("employer");


        this.userBussinessRules.employerRegistrationCheck(employer);
        this.userBussinessRules.isEmailExist(employer.getEmail());
        this.userBussinessRules.isWebSiteExist(employer.getWebsite());
        this.userBussinessRules.isMailValidatorIsveren(employer);

        this.employerDao.save(employer);


    }

    @Override//giriş
    public LoginMessage loginEmployer(LoginRequest loginRequest) {
        String msg = "Login Failed";
        Employer employer = this.employerDao.findByEmail(loginRequest.getEmail());
        if (employer != null) {
            String password = loginRequest.getPassword();
            String encodedPassword = employer.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employer> employee = this.employerDao.findOneByEmailAndPassword(loginRequest.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage( msg, false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("bu maile sahip bir employer yoktur", false);
        }

    }


    @Override
    public List<EmployerWithJobAdvertisementDto> getIsverenWithIsIlanıDetails() {
        return null;
                //this.employerDao.getIsverenWithIsIlanıDetails();
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
