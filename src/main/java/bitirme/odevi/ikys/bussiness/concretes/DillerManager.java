package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IDillerService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.DilDao;
import bitirme.odevi.ikys.entitites.concretes.Dil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DillerManager implements IDillerService {
    private DilDao dillerDao;

    @Autowired
    public DillerManager(DilDao dillerDao) {
        super();
        this.dillerDao = dillerDao;
    }
    @Override
    public DataResult<List<Dil>> getDiller() {

        return new SuccessDataResult<>(this.dillerDao.findAll(),"Diller Listelendi");
    }

    @Override
    public DataResult<List<Dil>> findAllByName() {
        return new SuccessDataResult<>(this.dillerDao.findAllByName("name"),"Diller Listelendi");
    }

}
