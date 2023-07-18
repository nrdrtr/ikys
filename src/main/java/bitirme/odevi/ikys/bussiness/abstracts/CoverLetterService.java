package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.CoverLetterAddRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService {

    Result add(CoverLetterAddRequest request);
    Result update(CoverLetter coverLetter);
    Result delete(int id);
    DataResult<CoverLetter> getById(int id);
    DataResult<List<CoverLetter>> getAll();
    DataResult<List<CoverLetter>> getAllByJobSeekerId(int jobSeekerId);


}
