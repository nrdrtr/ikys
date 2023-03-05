package bitirme.odevi.ikys.dataAccess.abstracts;



import bitirme.odevi.ikys.entitites.concretes.Kullanıcı;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullanıcıDao extends JpaRepository<Kullanıcı, Integer> {

    boolean existsByePosta(String ePosta);


}


