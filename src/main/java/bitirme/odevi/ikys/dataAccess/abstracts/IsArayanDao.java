package bitirme.odevi.ikys.dataAccess.abstracts;



import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsArayanDao extends JpaRepository<IsArayan,Integer>     {

    IsArayan getIsArayanById(int id);


}
