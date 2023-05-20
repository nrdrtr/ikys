package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Technology;
import bitirme.odevi.ikys.entitites.dto.TechnologyUpdateDto;

import java.util.List;

public interface TechnologyService {


    DataResult<List<Technology>> getTeknoloji();

    Result add(Technology technology);

    Result deleteTeknolojiById(int id);

    Result updateTechnology(TechnologyUpdateDto pl);


}
