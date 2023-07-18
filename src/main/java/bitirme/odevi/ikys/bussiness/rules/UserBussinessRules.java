package bitirme.odevi.ikys.bussiness.rules;

import bitirme.odevi.ikys.core.utilities.exceptions.BusinessException;
import bitirme.odevi.ikys.dataAccess.abstracts.EmployerDao;
import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerDao;
import bitirme.odevi.ikys.dataAccess.abstracts.UserDao;
import bitirme.odevi.ikys.entitites.concretes.Employer;
import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@AllArgsConstructor
public class UserBussinessRules {

    private UserDao userDao;
    private JobSeekerDao jobseekerDao;
    private EmployerDao employerDao;

    public void jobSeekerRegistrationCheck(JobSeeker jobseeker) {
        if (jobseeker.getName().isEmpty() || jobseeker.getSurname().isEmpty() || jobseeker.getIdentityNumber().isEmpty() || jobseeker.getBirthDate() == null
                || jobseeker.getEmail().isEmpty() || jobseeker.getPassword().isEmpty() || jobseeker.getPasswordAgain().isEmpty()) {

            throw new BusinessException("Tüm alanlar zorunludur. Lütfen tekrar deneyin.");
        }

    }

    public void employerRegistrationCheck(Employer employer) {//şirket adı, web sitesi, e-posta, telefon, şifre ve şifre tekrarı bilgileri
        if (employer.getCompanyName().isEmpty() || employer.getWebsite().isEmpty()
                || employer.getEmail().isEmpty() || employer.getPhoneNumber().isEmpty()
                || employer.getPassword().isEmpty() || employer.getPasswordAgain().isEmpty()) {

            throw new BusinessException("Tüm alanlar zorunludur. Lütfen tekrar deneyin.");
        }

    }

public void companyNameCheck(String companyName) {
        if (this.employerDao.existsBycompanyName(companyName)) {
            throw new BusinessException("Bu şirket adı zaten kayıtlıdır.");
        }
    }

    public void isEmailExist(String email) {
        if (this.userDao.existsByemail(email)) {
            throw new BusinessException("Bu e-posta adresi zaten kayıtlıdır.");
        }

    }

    public void identityNumberCheck(String kimlikNumarasi) {

        if (this.jobseekerDao.existsByIdentityNumber(kimlikNumarasi)) {
            throw new BusinessException("Bu kimlik numarası zaten kayıtlıdır.");
        }
        if (kimlikNumarasi.length() != 11) {
            throw new BusinessException("Kimlik numarası 11 haneli olmalıdır.");
        }

    }

    public void isWebSiteExist(String webSite) {//önceki hali boolen idi
        if (this.employerDao.existsBywebsite(webSite)) {
            throw new BusinessException("Bu web sitesi zaten kayıtlıdır.");
        }
    }

    public void isMailValidatorJobSeeker(JobSeeker jobseeker) {

        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(jobseeker.getEmail());
        if (!m.matches()) {
            throw new BusinessException("Geçersiz e-posta adresi");
        }

    }

    public void checkPasswordsMatch(String password, String passwordAgain) {
        if (!password.equals(passwordAgain)) {
            throw new BusinessException("Şifreler eşleşmiyor.");
        }
    }





    public boolean isMailValidatorIsveren(Employer employer) {

//        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.(com|net|org)$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher m = pattern.matcher(employer.getEmail());
//        if (m.matches() && m.group().substring(m.group().indexOf("@") + 1).equals(employer.getWebsite())) {
//            return true;
//        } else {
//            throw new BusinessException("Geçersiz e-posta adresi");
//        }
        return true;
    }

    public void birthDateCheck(LocalDate birthDate) {
        if (birthDate == null) {
            throw new BusinessException("Doğum tarihi boş bırakılamaz.");
        }
    }
}

















