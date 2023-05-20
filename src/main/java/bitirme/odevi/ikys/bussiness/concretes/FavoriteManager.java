package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.FavoriteService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.FavoriteDao;
import bitirme.odevi.ikys.entitites.concretes.Favorite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FavoriteManager implements FavoriteService {

    private FavoriteDao favoriteDao;

    @Override
    public DataResult<List<Favorite>> getFavoriByIsArayanId(int id) {
        return new SuccessDataResult<>(this.favoriteDao.getFavoriteByJobSeekerId(id), "favorilerin listelendi");
    }

    @Override
    public Result save(Favorite favorite) {
        this.favoriteDao.save(favorite);
        return new SuccessDataResult<>("favorite güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.favoriteDao.deleteById(id);
        return new SuccessResult("favori silindi");
    }

    @Override
    public Result deleteFavoriByIsArayanIdAndIsIlaniId(int jobSeekerId, int jobAdvertId) {
        return null;
    }


}
