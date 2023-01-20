package bitirme.odevi.ikys.bussiness.abstracts;



import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Favori;

import java.util.List;

public interface FavoriService {


    DataResult<List<Favori>> getFavoriteByIsArayanId(int id);

    Result save(Favori favori);

    Result delete(int id);
    

}
