package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.TeknolojiService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.TeknolojiDao;
import bitirme.odevi.ikys.entitites.concretes.Teknoloji;
import bitirme.odevi.ikys.entitites.dto.TechnologyUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeknolojiManger implements TeknolojiService {

    private TeknolojiDao teknolojiDao;

    @Override
    public DataResult<List<Teknoloji>> getTeknoloji() {
        return new SuccessDataResult<>(this.teknolojiDao.findAll(),"Teknolojiler getirildi");
    }

    @Override
    public Result add(Teknoloji teknoloji) {
        this.teknolojiDao.save(teknoloji);
        return new  SuccessResult(true,"başarıyla kaydedildi");
    }

    @Override
    public Result deleteTeknolojiById(int id) {
        return null;
    }

    @Override
    public Result updateTechnology(TechnologyUpdateDto pl) {
        return null;
    }
}
