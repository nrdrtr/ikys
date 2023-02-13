package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.OkulService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.OkulDao;
import bitirme.odevi.ikys.entitites.concretes.Okul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OkulManager implements OkulService {

    private OkulDao okulDao;

    @Autowired
    public OkulManager(OkulDao okulDao) {
        this.okulDao = okulDao;
    }

    @Override
    public Result addSchool(Okul okul) {
        return null;
    }

    @Override
    public DataResult<List<Okul>> getAll() {
        return  new SuccessDataResult<>(this.okulDao.findAll(),"Okullar getirildi");
    }
}
