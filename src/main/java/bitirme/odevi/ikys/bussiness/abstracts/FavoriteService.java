package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Favorite;

import java.util.List;

public interface FavoriteService {

    DataResult<List<Favorite>> getFavoriByIsArayanId(int id);

    Result save(Favorite favorite);

    Result delete(int id);

    Result deleteFavoriByIsArayanIdAndIsIlaniId(int jobSeekerId, int jobAdvertId);


}
