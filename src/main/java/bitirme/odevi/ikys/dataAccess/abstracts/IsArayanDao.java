package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IsArayanDao extends JpaRepository<IsArayan, Integer> {
    IsArayan getIsArayanById(int id);

    //IsArayan findByePosta(String ePosta);

    @Transactional
    void deleteIsArayanById(int id);

    boolean existsBykimlikNumarasi(String kimlikNumarasi);


}
