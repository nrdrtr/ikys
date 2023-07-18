package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.CurriculumVitae;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CurriculumVitaeService {


    Result add(CurriculumVitae curriculumVitae);
    Result update(CurriculumVitae resume);
    Result delete(int id);
    DataResult<CurriculumVitae> getById(int id);
    DataResult<List<CurriculumVitae>> getAll();

    DataResult<CurriculumVitae> getByJobSeekerId(int jobSeekerId);

    Result uploadPicture(int cvId, MultipartFile file) throws IOException;


}
