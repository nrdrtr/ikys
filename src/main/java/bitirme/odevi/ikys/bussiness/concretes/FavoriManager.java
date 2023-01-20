package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.FavoriService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.FavoriDao;
import bitirme.odevi.ikys.entitites.concretes.Favori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriManager  implements FavoriService {

    private  FavoriDao favoriDao;

    @Autowired
    public FavoriManager(FavoriDao favoriDao) {
        this.favoriDao = favoriDao;
    }

    @Override
    public DataResult<List<Favori>> getFavoriteByIsArayanId(int id) {
        return new SuccessDataResult<>(this.favoriDao.getFavoriteByIsArayanId(id),"favorilerin listelendi");
    }

    @Override
    public Result save(Favori favori) {
            this.favoriDao.save(favori);
            return new SuccessDataResult<>("favori güncellendi");
        }

    @Override
    public Result delete(int id) {
        this.favoriDao.deleteById(id);
        return new SuccessResult("favori silindi");
    }



}
