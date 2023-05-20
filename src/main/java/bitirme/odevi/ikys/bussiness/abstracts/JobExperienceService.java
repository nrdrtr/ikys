package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;

import java.util.List;

public interface JobExperienceService {

    DataResult<List<bitirme.odevi.ikys.entitites.concretes.JobExperience>> getIsDeneyimiByOzgecmisId(int id);

    Result add(bitirme.odevi.ikys.entitites.concretes.JobExperience jobExperience);

    Result delete(int id);


}
