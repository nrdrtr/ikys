package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.entitites.concretes.IsArayan;

import java.util.List;

public interface IsArayanService {

    List<IsArayan> getAllIsArayan();
    void save(IsArayan isArayan);
}
