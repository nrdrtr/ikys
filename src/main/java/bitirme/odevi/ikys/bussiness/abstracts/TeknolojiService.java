package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Teknoloji;
import bitirme.odevi.ikys.entitites.dto.TechnologyUpdateDto;

import java.util.List;

public interface TeknolojiService {


    DataResult<List<Teknoloji>> getTeknoloji();

    Result add(Teknoloji teknoloji);

    Result deleteTeknolojiById(int id);

    Result updateTechnology(TechnologyUpdateDto pl);


}
