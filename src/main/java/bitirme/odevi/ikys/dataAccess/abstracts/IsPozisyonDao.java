package bitirme.odevi.ikys.dataAccess.abstracts;



import bitirme.odevi.ikys.entitites.concretes.IsPozisyonu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsPozisyonDao extends JpaRepository<IsPozisyonu, Integer> {


}
