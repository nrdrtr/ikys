package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TechnologyDao extends JpaRepository<Technology, Integer> {

    List<Technology> getTechnologyByCurriculumVitaeId(int id);//

    @Transactional
    void deleteTechnologyById(int id);

}
