package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.TechnologyService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.TechnologyDao;
import bitirme.odevi.ikys.entitites.concretes.Technology;
import bitirme.odevi.ikys.entitites.dto.TechnologyUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnologyManger implements TechnologyService {

    private TechnologyDao technologyDao;

    @Override
    public DataResult<List<Technology>> getTeknoloji() {
        return new SuccessDataResult<>(this.technologyDao.findAll(),"Teknolojiler getirildi");
    }

    @Override
    public Result add(Technology teknoloji) {
        this.technologyDao.save(teknoloji);
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
