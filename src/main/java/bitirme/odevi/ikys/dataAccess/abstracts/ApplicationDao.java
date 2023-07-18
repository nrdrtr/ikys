package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationDao extends JpaRepository<Application, Integer> {
    List<Application> findAllByJobSeekerId(int jobSeekerId);
    List<Application> findByJobAdvertisementId(int jobAdvertisementId);

    List<Application> findByJobAdvertisement_Employer_Id(int employerId);


//    @Query("SELECT new bitirme.odevi.ikys.bussiness.requests.JobApplicationDTO" +
//            "(ja.explanation, a.status, js.name, js.surname) " +
//            "FROM JobAdvertisement ja " +
//            "JOIN ja.applications a " +
//            "JOIN a.jobSeeker js " +
//            "WHERE ja.employer.id = :employerId")
//    List<JobApplicationDTO> getJobApplicationsByEmployerId(@Param("employerId") int employerId);

}
