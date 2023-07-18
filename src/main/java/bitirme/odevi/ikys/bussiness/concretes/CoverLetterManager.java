package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.CoverLetterService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.CoverLetterAddRequest;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.CoverLetterDao;
import bitirme.odevi.ikys.entitites.concretes.CoverLetter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoverLetterManager implements CoverLetterService {

    private CoverLetterDao coverLetterDao;
    private ModelMapperService modelMapperService;


    @Override
    public Result add(CoverLetterAddRequest request) {
        CoverLetter coverLetter = this.modelMapperService.forRequest().map(request, CoverLetter.class);
        this.coverLetterDao.save(coverLetter);
        return new SuccessResult("Ön yazı eklendi");
    }

    @Override
    public Result update(CoverLetter coverLetter) {
        CoverLetter updatedCoverLetter = this.coverLetterDao.getById(coverLetter.getId());
        updatedCoverLetter.setDescription(coverLetter.getDescription());
        this.coverLetterDao.save(updatedCoverLetter);
        return new SuccessResult("Ön yazı güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.coverLetterDao.deleteById(id);
        return new SuccessResult("Ön yazı silindi");
    }

    @Override
    public DataResult<CoverLetter> getById(int id) {
        return new SuccessDataResult<>(this.coverLetterDao.findById(id).orElse(null));
    }

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
    }

    @Override
    public DataResult<List<CoverLetter>> getAllByJobSeekerId(int employeeId) {
        return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.getAllByJobSeekerId(employeeId));
    }

}
