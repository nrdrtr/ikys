package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.TeknolojiService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.TeknolojiDao;
import bitirme.odevi.ikys.entitites.concretes.Teknoloji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeknolojiManger implements TeknolojiService {

    private TeknolojiDao teknolojiDao;

    @Autowired
    public TeknolojiManger(TeknolojiDao teknolojiDao) {
        this.teknolojiDao = teknolojiDao;
    }

    @Override
    public DataResult<List<Teknoloji>> getTeknoloji() {
        return new SuccessDataResult<>(this.teknolojiDao.findAll(),"Teknolojiler getirildi");
    }

    @Override
    public Result add(Teknoloji teknoloji) {
        this.teknolojiDao.save(teknoloji);
        return new  SuccessResult(true,"başarıyla kaydedildi");
    }
}
