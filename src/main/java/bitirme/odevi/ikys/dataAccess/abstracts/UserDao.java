package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Employer;
import bitirme.odevi.ikys.entitites.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    boolean existsByemail(String email);
    //Kullanıcı findByUserePostaIgnoreCase(String emailId);

    Optional<User> findByEmail(String email);

    Optional<Employer> findOneByEmailAndPassword(String email, String password);


    User getUserById(int id);


}


