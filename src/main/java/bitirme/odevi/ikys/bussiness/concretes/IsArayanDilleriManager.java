package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.JobSeekerLanguagesService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.dataAccess.abstracts.JobSeekerLanguagesDao;
import bitirme.odevi.ikys.entitites.concretes.JobseekerLanguages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IsArayanDilleriManager implements JobSeekerLanguagesService {

    @Override
    public DataResult<List<JobseekerLanguages>> getJobSeekerLanguageByCurriculaVitaeId(int id) {
        return null;
    }

    @Override
    public Result deleteJobSeekerLanguageById(int id) {
        return null;
    }

    private JobSeekerLanguagesDao isArayanDilleriDao;


}
