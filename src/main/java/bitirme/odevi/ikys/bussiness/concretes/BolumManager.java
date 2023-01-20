package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.BolumService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.BolumDao;
import bitirme.odevi.ikys.entitites.concretes.Bolum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BolumManager  implements BolumService {
    private BolumDao bolumDao;

    @Autowired
    public BolumManager(BolumDao bolumDao) {
        this.bolumDao = bolumDao;
    }

    @Override
    public DataResult<List<Bolum>> getAll() {

        return  new SuccessDataResult<>(this.bolumDao.findAll(),"Bolumler Listelendi");
    }

    @Override
    public void save(Bolum bolum) {
           this.bolumDao.save(bolum);
    }
}
