package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Ozgecmis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OzgecmisDao extends JpaRepository<Ozgecmis, Integer> {

    Ozgecmis findByIsArayanId(int id);
}



