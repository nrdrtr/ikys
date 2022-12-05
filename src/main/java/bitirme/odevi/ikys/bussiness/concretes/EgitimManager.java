package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.EgitimService;
import bitirme.odevi.ikys.dataAccess.abstracts.EgitimDao;
import bitirme.odevi.ikys.entitites.concretes.Egitim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EgitimManager implements EgitimService {

    private EgitimDao egitimDao;

    @Autowired
    public EgitimManager(EgitimDao egitimDao) {
        this.egitimDao = egitimDao;
    }

    @Override
    public List<Egitim> egitimGetAll() {
        return this.egitimDao.findAll();
    }

    @Override
    public void save(Egitim egitim) {

        this.egitimDao.save(egitim);
    }

    @Override
    public Page<Egitim> findAllByEgitim(int id, Pageable pageable) {
        return this.egitimDao.findAllById(id,pageable);
    }



}
