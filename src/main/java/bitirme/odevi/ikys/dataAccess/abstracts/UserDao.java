package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    boolean existsByePosta(String ePosta);
    //Kullanıcı findByUserePostaIgnoreCase(String emailId);

    User findByePosta(String ePosta);


}


