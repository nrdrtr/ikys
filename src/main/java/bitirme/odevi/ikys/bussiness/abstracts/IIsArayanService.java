package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;

import java.util.List;

public interface IIsArayanService {

   List<IsArayan> getIsArayan();
    void save(IsArayan isArayan);
}
