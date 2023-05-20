package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

    CurriculumVitae findByJobSeekerId(int id);
}



