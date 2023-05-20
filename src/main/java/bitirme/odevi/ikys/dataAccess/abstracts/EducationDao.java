package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.Education;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EducationDao extends JpaRepository<Education, Integer> {
    Page<Education> findAllById(int id, Pageable pageable);

    List<Education> getEducationEndDateByCurriculumVitaeId(int id, Sort sort); //

    // @JoinColumn(name = "currivulum_vitae_id") bitisTarihi   @JoinColumn(name = "") Egitim bitis tarihi ozgecmis_id

    //    private CurriculumVitae curriculumVitae;
    //	Adayların okudukları okullar mezuniyet yılına göre tersten sıralanabilmelidir.

    @Transactional
    void deleteEducationById(int id);

}


