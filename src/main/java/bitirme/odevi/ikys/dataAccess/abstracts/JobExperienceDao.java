package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.JobExperience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    List<JobExperience> getJobExperienceByCurriculumVitae(int id, Sort sort);//
    @Transactional
    void deleteJobExperienceById(int id);

}



