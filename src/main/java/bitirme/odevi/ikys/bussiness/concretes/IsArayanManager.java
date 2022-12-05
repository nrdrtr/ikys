package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsArayanService;
import bitirme.odevi.ikys.dataAccess.abstracts.IsArayanDao;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsArayanManager implements IsArayanService {

    private IsArayanDao isArayanDao;

    @Autowired
    public IsArayanManager(IsArayanDao isArayanDao) {
        super();
        this.isArayanDao = isArayanDao;
    }

    @Override
    public List<IsArayan> getAllIsArayan() {
        return isArayanDao.findAll();
    }

    @Override
    public void save(IsArayan isArayan) {

    }
}
