package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.FavoriteService;
import bitirme.odevi.ikys.bussiness.requests.JobSeekerAddFavorite;
import bitirme.odevi.ikys.bussiness.requests.JobSeekerRemoveFavorite;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.FavoriteDao;
import bitirme.odevi.ikys.entitites.concretes.Favorite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FavoriteManager implements FavoriteService {

    private FavoriteDao favoriteDao;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<Favorite>> getFavoriByIsArayanId(int id) {
        return new SuccessDataResult<>(this.favoriteDao.getFavoriteByJobSeekerId(id), "favorilerin listelendi");
    }

    @Override
    public Result save(Favorite favorite) {
        this.favoriteDao.save(favorite);
        return new SuccessDataResult<>("favorin ilanın eklendi");
    }

    @Override
    public Result addFavoriteAdvertisemement(JobSeekerAddFavorite jobSeekerAddFavorite) {
        Favorite favorite = this.modelMapperService.forRequest().map(jobSeekerAddFavorite, Favorite.class);
        this.favoriteDao.save(favorite);
        return new SuccessResult("favori ilan eklendi");

    }


    @Override
    public Result delete(int id) {
        this.favoriteDao.deleteById(id);
        return new SuccessResult("favori silindi");
    }

    @Override
    public Result removeFavoriteAdvertisement(JobSeekerRemoveFavorite  jobSeekerRemoveFavorite) {
         Favorite favorite = favoriteDao.findByJobSeekerIdAndJobAdvertisementId(
                jobSeekerRemoveFavorite.getJobSeekerId(),
                jobSeekerRemoveFavorite.getJobAdvertisementId()
        );

        favoriteDao.delete(favorite);
        return new SuccessResult("ilan favorilerden kaldırıldı.");
    }

    @Override
    public Result deleteFavoriByIsArayanIdAndIsIlaniId(int jobSeekerId, int jobAdvertId) {
        return null;
    }


}
