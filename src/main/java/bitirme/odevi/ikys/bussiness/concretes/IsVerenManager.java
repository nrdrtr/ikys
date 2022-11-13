package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsVerenService;
import bitirme.odevi.ikys.dataAccess.abstracts.IsVerenDao;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsVerenManager implements IsVerenService {

    private IsVerenDao isVerenDao;

    @Autowired
    public IsVerenManager(IsVerenDao isVerenDao) {
        this.isVerenDao = isVerenDao;
    }

    @Override
    public List<IsVeren> isVeren() {
        return this.isVerenDao.findAll();
    }

    @Override
    public void save(IsVeren isVeren) {
        this.isVerenDao.save(isVeren);

    }
}
