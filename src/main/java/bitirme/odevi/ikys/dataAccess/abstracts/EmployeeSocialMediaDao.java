package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.JobSeekerSocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSocialMediaDao extends JpaRepository<JobSeekerSocialMedia, Integer> {

    List<JobSeekerSocialMedia> findAllByJobSeekerId(int id);
}