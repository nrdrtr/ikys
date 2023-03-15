package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;

import java.util.List;

public interface IsArayanService {

    DataResult<List<IsArayan>> getAllIsArayan();

    Result save(IsArayan isArayan);

  //  DataResult<IsArayan> findByePosta(String ePosta);
    Result deleteIsArayanById(int id);



}
