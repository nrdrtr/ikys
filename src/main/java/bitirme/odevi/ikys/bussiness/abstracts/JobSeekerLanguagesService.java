package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobseekerLanguages;

import java.util.List;

public interface JobSeekerLanguagesService {
    //  Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage);

    DataResult<List<JobseekerLanguages>> getJobSeekerLanguageByCurriculaVitaeId(int id);

    Result deleteJobSeekerLanguageById(int id);

}
