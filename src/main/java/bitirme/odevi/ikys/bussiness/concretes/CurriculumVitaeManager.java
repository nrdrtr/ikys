package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.CurriculumVitaeService;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.CurriculumVitaeDao;
import bitirme.odevi.ikys.entitites.concretes.CurriculumVitae;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
@AllArgsConstructor

public class CurriculumVitaeManager implements CurriculumVitaeService{


    private final CurriculumVitaeDao curriculumVitaeDao;
    private final ModelMapperService modelMapperService;


    @Override
    public DataResult<CurriculumVitae> getByJobSeekerId(int employeeId) {
        return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.findByJobSeekerId(employeeId));
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        this.curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult("CV eklendi");
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        if (this.curriculumVitaeDao.findAll().isEmpty())
            return new SuccessDataResult<>("Cv bulunamadı");
        return new SuccessDataResult<>(this.curriculumVitaeDao.findAll());

    }

    @Override
    public Result update(CurriculumVitae resume) {
        CurriculumVitae updResume = this.curriculumVitaeDao.getById(resume.getId());

        updResume.setImageUrl(resume.getImageUrl());
        return new SuccessResult("Cv güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.curriculumVitaeDao.deleteById(id);
        return new SuccessResult("Cv silindi");
    }

    @Override
    public DataResult<CurriculumVitae> getById(int id) {
        return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.findById(id).orElse(null));
    }

    @Override
    public Result uploadPicture(int cvId, MultipartFile file) throws IOException {
//        var result = this.cloudinaryService.addPicture(file);
//        var url = result.getData().get("url");
//
//        Ozgecmis ref = this.curriculumVitaeDao.getOne(cvId);
//        ref.setResimUrl(url.toString());
//        this.curriculumVitaeDao.save(ref);
//
        return new SuccessResult("Success: Resim ekleme işlemi başarılı!");
    }


}
