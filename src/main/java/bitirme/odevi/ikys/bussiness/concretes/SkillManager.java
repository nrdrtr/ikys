package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.SkillService;
import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.SkillAddRequest;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.SkillDao;
import bitirme.odevi.ikys.entitites.concretes.Skill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkillManager implements SkillService {

    private SkillDao skillDao;
    private ModelMapperService modelMapperService;

    @Override
    public Result add(SkillAddRequest request) {
        Skill skill = this.modelMapperService.forRequest().map(request, Skill.class);
        this.skillDao.save(skill);
        return new SuccessResult("Skill eklendi");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
    }

    @Override
    public DataResult<List<Skill>> getAllByJobSeekerId(int employeeId) {
        return new SuccessDataResult<>(this.skillDao.findAllByJobSeekerId(employeeId));
    }

    @Override
    public Result update(Skill skill) {
        Skill updSkill = this.skillDao.getById(skill.getId());
        updSkill.setProgrammingLanguage(skill.getProgrammingLanguage());
        updSkill.setTechnologyName(skill.getProgrammingLanguage());
        this.skillDao.save(updSkill);
        return new SuccessResult("Yetenek bilgisi güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.skillDao.deleteById(id);
        return new SuccessResult("Yetenek bilgisi silindi");
    }

    @Override
    public DataResult<Skill> getById(int id) {
        return new SuccessDataResult<Skill>(this.skillDao.findById(id).orElse(null));
    }

}
