package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.JobseekerLanguages;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerLanguagesDao extends JpaRepository<JobseekerLanguages, Integer> {

    List<JobseekerLanguages> getJobseekerLanguagesByCurriculumVitaeId(int id);

    List<JobseekerLanguages> findAllByJobSeekerId(int id);

    @Transactional
    void deleteJobseekerLanguagesById(int id);



}







