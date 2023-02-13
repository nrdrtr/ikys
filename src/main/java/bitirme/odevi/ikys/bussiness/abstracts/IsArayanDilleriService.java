package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsArayanDilleri;

import java.util.List;

public interface IsArayanDilleriService {
    //  Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage);

    DataResult<List<IsArayanDilleri>> getJobSeekerLanguageByCurriculaVitaeId(int id);

    Result deleteJobSeekerLanguageById(int id);

}
