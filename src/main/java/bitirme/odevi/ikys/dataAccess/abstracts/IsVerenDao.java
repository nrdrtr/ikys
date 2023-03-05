package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IsVerenDao extends JpaRepository<IsVeren, Integer> {

    @Query  ("Select new bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto" +
            "(i.id, i.sirketAdi, il.description) " +
            "From IsVeren i Inner Join i.isIlani il")
    List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails();

    boolean existsBywebsite(String website);

    IsVeren getIsVerenById(int id);

    List<IsVeren> getIsVerenByGuncelMiTrue();

    @Transactional
    void deleteIsVerenById(int id);

//    @Transactional
//    @Modifying
//    @Query("Update IsVeren set guncelMi =:update where id =:employerId")
//    void changeIsUpdated(boolean update, int employerId);

}




