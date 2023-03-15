package bitirme.odevi.ikys.bussiness.rules;

import bitirme.odevi.ikys.core.utilities.exceptions.BusinessException;
import bitirme.odevi.ikys.dataAccess.abstracts.IsArayanDao;
import bitirme.odevi.ikys.dataAccess.abstracts.IsVerenDao;
import bitirme.odevi.ikys.dataAccess.abstracts.UserDao;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@AllArgsConstructor
public class UserBussinessRules {

    private UserDao userDao;
    private IsArayanDao isArayanDao;
    private IsVerenDao isVerenDao;

    public boolean jobSeekerRegistrationCheck(IsArayan isArayan) {
        if (isArayan.getAdi().isEmpty() || isArayan.getSoyadi().isEmpty() || isArayan.getKimlikNumarasi().isEmpty() || isArayan.getDogumTarihi() == null
                || isArayan.getEPosta().isEmpty() || isArayan.getSifre().isEmpty() || isArayan.getSifreTekrari().isEmpty()) {

            throw new BusinessException("Tüm alanlar zorunludur. Lütfen tekrar deneyin.");
        }
        return true;

    }

    public boolean employerRegistrationCheck(IsVeren isVeren) {//şirket adı, web sitesi, e-posta, telefon, şifre ve şifre tekrarı bilgileri
        if (isVeren.getSirketAdi().isEmpty() || isVeren.getWebsite().isEmpty()
                || isVeren.getEPosta().isEmpty() || isVeren.getTelefonNumarasi().isEmpty()
                || isVeren.getSifre().isEmpty() || isVeren.getSifreTekrari().isEmpty()) {

            throw new BusinessException("Tüm alanlar zorunludur. Lütfen tekrar deneyin.");
        } else {

            return true;
        }

    }

    //posta kontrolü
    public boolean isEmailExist(String email) {
        if (this.userDao.existsByePosta(email)) {
            throw new BusinessException("Bu e-posta adresi zaten kayıtlıdır.");
        }
        return true;
    }


    public boolean isKimlikNumarasiExist(String kimlikNumarasi) {
        if (this.isArayanDao.existsBykimlikNumarasi(kimlikNumarasi)) {
            throw new BusinessException("Bu kimlik numarası zaten kayıtlıdır.");
        }
        return true;
    }

    public boolean isWebSiteExist(String webSite) {
        if (this.isVerenDao.existsBywebsite(webSite)) {
            throw new BusinessException("Bu web sitesi zaten kayıtlıdır.");
        }
        return true;
    }

    public boolean isMailValidatorIsArayan(IsArayan isArayan) {

        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(isArayan.getEPosta());
        if (m.matches()) {
            return true;
        } else {
            throw new BusinessException("Geçersiz e-posta adresi");
        }

    }

    public boolean isMailValidatorIsveren(IsVeren isVeren) {

        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.(com|net|org)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(isVeren.getEPosta());
        if (m.matches() && m.group().substring(m.group().indexOf("@") + 1).equals(isVeren.getWebsite())) {
            return true;
        } else {
            throw new BusinessException("Geçersiz e-posta adresi");
        }
    }
}

















