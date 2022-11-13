package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;

import java.util.List;

public interface IsVerenService {

    List<IsVeren> isVeren();
    void save(IsVeren isVeren);
}
