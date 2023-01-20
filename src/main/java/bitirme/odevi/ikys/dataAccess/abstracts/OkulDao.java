package bitirme.odevi.ikys.dataAccess.abstracts;



import bitirme.odevi.ikys.entitites.concretes.Okul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OkulDao extends JpaRepository<Okul, Integer> {

}



