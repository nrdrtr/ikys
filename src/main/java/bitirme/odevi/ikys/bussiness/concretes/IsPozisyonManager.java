package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsPozisyonService;
import bitirme.odevi.ikys.dataAccess.abstracts.IsPozisyonDao;
import bitirme.odevi.ikys.entitites.concretes.IsPozisyonu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IsPozisyonManager implements IsPozisyonService {

  private IsPozisyonDao isPozisyonDao;

    @Autowired
    public IsPozisyonManager(IsPozisyonDao isPozisyonDao) {
        this.isPozisyonDao = isPozisyonDao;
    }

    @Override
    public List<IsPozisyonu> getIsPozisyonu() {
        return this.isPozisyonDao.findAll();
    }
}
