package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.Egitim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EgitimDao extends JpaRepository<Egitim, Integer> {
    Page<Egitim> findAllById(int id, Pageable pageable);

    List<Egitim> getEgitimBitisTarihiByOzgecmisId(int id, Sort sort);
    //	Adayların okudukları okullar mezuniyet yılına göre tersten sıralanabilmelidir.

    @Transactional
    void deleteEgitimById(int id);

}


