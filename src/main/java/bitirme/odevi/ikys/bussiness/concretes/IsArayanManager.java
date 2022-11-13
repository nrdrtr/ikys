package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IIsArayanService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.IsArayanDao;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsArayanManager implements IIsArayanService {

    private IsArayanDao isArayanDao;

    @Autowired
    public IsArayanManager(IsArayanDao isArayanDao) {
        super();
        this.isArayanDao = isArayanDao;
    }

    @Override
    public List<IsArayan> getIsArayan() {
        return this.isArayanDao.findAll();
    }

    @Override
    public void save(IsArayan isArayan) {

    }
}
