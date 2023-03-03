package bitirme.odevi.ikys.bussiness.rules;

import bitirme.odevi.ikys.core.utilities.exceptions.BusinessException;

import bitirme.odevi.ikys.dataAccess.abstracts.KullanıcıDao;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserBussinessRules {

    private KullanıcıDao kullanıcıDao;

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
        if (this.kullanıcıDao.existsByePosta(email)) {
            throw new BusinessException("Bu e-posta adresi zaten kayıtlıdır.");
        }
        return true;
    }

}
















