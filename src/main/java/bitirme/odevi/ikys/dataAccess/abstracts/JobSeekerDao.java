package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    JobSeeker getJobSeekerById(int id);

    JobSeeker findByEmail(String email);
    Optional<JobSeeker> findOneByEmailAndPassword(String email, String password);
    @Transactional
    void deleteJobSeekerById(int id);
    //isverenlerin fovorilerine ekledikleri iş ilanlarını veren
   // List<JobAdvertisement> getJobAdvertisementsByFavoriteJobAdvertisements_Id(int id);

    boolean existsByIdentityNumber(String identityNumber);




}
