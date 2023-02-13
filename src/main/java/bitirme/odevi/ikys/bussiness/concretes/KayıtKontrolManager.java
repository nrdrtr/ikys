package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.KayıtKontrol;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import bitirme.odevi.ikys.entitites.concretes.Kullanıcı;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class KayıtKontrolManager implements KayıtKontrol {

    @Override
    public boolean isItEmptyIsArayan(IsArayan isArayan) {
        if (isArayan.getAdi().isEmpty() && isArayan.getSoyadi().isEmpty() && isArayan.getKimlikNumarasi().isEmpty() && isArayan.getDogumTarihi().format(DateTimeFormatter.ISO_DATE).isEmpty() &&
                isArayan.getEPosta().isEmpty() && isArayan.getSifre().isEmpty() && isArayan.getSifreTekrari().isEmpty() == true ){
            return false;
        }
        return true;
    }

    @Override
    public boolean isItEmptyIsVeren(IsVeren isVeren) {

        return true;
    }
}
