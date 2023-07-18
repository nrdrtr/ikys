package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.bussiness.requests.JobSeekerAddFavorite;
import bitirme.odevi.ikys.bussiness.requests.JobSeekerRemoveFavorite;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Favorite;

import java.util.List;

public interface FavoriteService {

    DataResult<List<Favorite>> getFavoriByIsArayanId(int id);

    Result save(Favorite favorite);

    Result addFavoriteAdvertisemement(JobSeekerAddFavorite jobSeekerAddFavorite);


    Result delete(int id);

    Result removeFavoriteAdvertisement(JobSeekerRemoveFavorite jobSeekerRemoveFavorite);
    Result deleteFavoriByIsArayanIdAndIsIlaniId(int jobSeekerId, int jobAdvertId);


}
