package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import bitirme.odevi.ikys.entitites.concretes.Kullanıcı;

public interface KayıtKontrol {
    boolean isItEmptyIsArayan(IsArayan isArayan);
    boolean isItEmptyIsVeren(IsVeren isVeren);
}
