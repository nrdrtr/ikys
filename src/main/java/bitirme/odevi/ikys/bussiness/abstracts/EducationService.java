package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Education;

import java.util.List;

public interface EducationService {

    DataResult<List<Education>> egitimGetAll();

    DataResult<List<Education>> egitimGetEgitimByOzgecmisId(int id);

    Result save(Education education);

    Result deleteEgitimById(int id);


}
