package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.JobPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    Page<JobPosition> findAll(Pageable pageable);
    JobPosition findById(int id);
    Page<JobPosition> findByJobNameContaining(String jobName, Pageable pageable);

    //List<JobPosition> findByJobTitleEndsWith(String isIsmi);


}
