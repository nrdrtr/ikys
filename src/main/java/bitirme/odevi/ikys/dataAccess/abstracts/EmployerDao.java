package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

//    @Query  ("Select new bitirme.odevi.ikys.entitites.dto.EmployerWithJobAdvertisementDto" +
//            "(i.id, i.sirketAdi, il.description) " +
//            "From Employer i Inner Join i.isIlani il")
//    List<EmployerWithJobAdvertisementDto> getIsverenWithIsIlanıDetails();

    boolean existsBywebsite(String website);

    Optional<Employer> findOneByEmailAndPassword(String email, String password);

    Employer findByEmail(String email);
    Employer getEmployerById(int id);

    //List<Employer> getEmployerByCurrentIsTrue(); düzelecek

    @Transactional
    void deleteEmployerById(int id);

//    @Transactional
//    @Modifying
//    @Query("Update Employer set guncelMi =:update where id =:employerId")
//    void changeIsUpdated(boolean update, int employerId);

}




