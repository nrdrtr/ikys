package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Employer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

//   @Query("SELECT new bitirme.odevi.ikys.bussiness.requests.EmployerJobAdvertisementsRequest(e.id, e.companyName, e.website," +
//           " e.phoneNumber, ja.id, ja.explanation, ja.salary, ja.numberOfOpenPositions, ja.endDate, ja.releaseDate, ja.workTime, " +
//           "ja.workType, ja.active) FROM Employer e INNER JOIN e.jobAdvertisements ja")
//    List<EmployerJobAdvertisementsRequest> getEmployersWithJobAdvertisements();


//    SELECT
//    ja.explanation AS job_explanation,
//    a.status AS application_status,
//    http://js.name AS job_seeker_first_name,
//    js.surname AS job_seeker_last_name
//            FROM
//    job_advertisements ja
//    JOIN applications a ON http://ja.id = a.job_advertisement_id
//    JOIN jobseekers js ON a.job_seeker_id = js.user_id
//            WHERE
//    ja.employer_id = 33 sorgusu için alanlar

//    @Query("SELECT new bitirme.odevi.ikys.bussiness.requests.")


//    @Query("SELECT new bitirme.odevi.ikys.bussiness.requests.JobApplicationDTO(ja.explanation, a.status, js.name, js.surname) " +
//            "FROM JobAdvertisement ja INNER JOIN ja.applications a INNER JOIN a.jobSeeker js WHERE ja.employer.id = :employerId")
//    Optional<JobApplicationDTO> getJobApplicationsByEmployerId(int employerId);


    boolean existsBywebsite(String website);

    Optional<Employer> findOneByEmailAndPassword(String email, String password);

    Employer findByEmail(String email);
    Employer getEmployerById(int id);
    boolean existsBycompanyName(String companyName);
//   @Query("SELECT ja FROM JobAdvertisement ja WHERE ja.employer = :employer")
//   Optional<Employer> getEmployerByJobAdvertisement(Employer employer);

    //List<Employer> getEmployerByCurrentIsTrue(); düzelecek

    @Transactional
    void deleteEmployerById(int id);

//    @Transactional
//    @Modifying
//    @Query("Update Employer set guncelMi =:update where id =:employerId")
//    void changeIsUpdated(boolean update, int employerId);

}




