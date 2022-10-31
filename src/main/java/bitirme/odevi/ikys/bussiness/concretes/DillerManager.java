package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IDillerService;
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
    public List<Dil> getDiller() {
        return this.dillerDao.findAll();
    }
}
