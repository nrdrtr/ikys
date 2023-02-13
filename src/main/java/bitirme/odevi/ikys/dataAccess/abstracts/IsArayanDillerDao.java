package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.IsArayanDilleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IsArayanDillerDao extends JpaRepository<IsArayanDilleri, Integer> {

    List<IsArayanDilleri> getIsArayanDilleriByOzgecmisId(int id);

    @Transactional
    void deleteIsArayanDilleriById(int id);



}







