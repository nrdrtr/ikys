package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.Sehir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SehirDao extends JpaRepository<Sehir, Integer> {
/*    @Transactional
    @Modifying
    @Query("update Sehir s set s.cityName = ?1 where s.cityName = ?2")
    int update(String cityName, String cityName1);*/


}

