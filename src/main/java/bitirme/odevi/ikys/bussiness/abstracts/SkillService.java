package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.SkillAddRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Skill;

import java.util.List;

public interface SkillService {

    Result add(SkillAddRequest request);
    Result update(Skill skill);
    Result delete(int id);
    DataResult<Skill> getById(int id);
    DataResult<List<Skill>> getAll();
    DataResult<List<Skill>> getAllByJobSeekerId(int jobSeekerId);
}
