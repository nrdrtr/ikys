package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IDillerService;
import bitirme.odevi.ikys.dataAccess.abstracts.DillerDao;
import bitirme.odevi.ikys.entitites.concretes.Diller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DillerManager implements IDillerService {
    private DillerDao dillerDao;

    @Autowired
    public DillerManager(DillerDao dillerDao) {
        super();
        this.dillerDao = dillerDao;
    }
    @Override
    public List<Diller> getDiller() {
        return this.dillerDao.findAll();
    }
}
