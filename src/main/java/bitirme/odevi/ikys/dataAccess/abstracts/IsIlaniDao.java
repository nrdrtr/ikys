package bitirme.odevi.ikys.dataAccess.abstracts;



import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.IsIlani;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IsIlaniDao extends JpaRepository<IsIlani, Integer> {


    IsIlani  findBySehir(String sehir);

    IsIlani findById(int id);
    //aktifMi
    List<IsIlani> findAllByAktifMiTrue(Sort sort);

    List<IsIlani> findByDescriptionStartsWith(String description);

    IsIlani findByDescription(String  description);


    @Query("Select new bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto"+
            "(p.id, v.sirketAdi, p.description)" +
            " From IsVeren v Inner Join  v.isIlani p")//JPQL (Java Persistence Query Language) sorguları yazıyoruz.     //JPQL sorguları SQL sorgularına çevrilir.
    List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails();

    List<IsIlani> findByIsPozisyonuId(int is_pozisyonu_id);//bir iş poziyonuna ait tüm iş ilanlarını getirir.


//    @Query("SELECT j FROM IsIlani j WHERE j.isPozisyonu = :isPozisyonu")//SELECT * FROM is_ilanlari WHERE is_pozisyonu_id = 5;
//    List<IsIlani> getIsIlaniByIsPozisyonuId(@Param("isPozisyonu") int isPozisyonuId); sonsuz döndü

//    List<JobAdvert> findAllByIsActiveTrue();
//
//    List<JobAdvert> getJobAdvertByEmployer_CompanyName(String companyName, Sort sort);
//
//    List<JobAdvert> getJobAdvertByEmployerId(int employerId, Sort sort);
//    ısActive
//
//    List<JobAdvert> findAllByIsActiveTrue(Sort sort);
//
//    List<JobAdvert> getJobAdvertByIsActiveTrueAndIsConfirmedTrue(Pageable pageable);
//
//    List<JobAdvert> getJobAdvertByIsActiveTrueAndIsConfirmedTrue();
//
//    @Transactional
//    @Modifying
//    @Query("Update JobAdvert set isActive =:active where id =:jobAdvertId")
//    void changeIsActive(boolean active, int jobAdvertId);
//
//    @Transactional
//    @Modifying
//    @Query("Update JobAdvert set isConfirmed =:confirm where id =:jobAdvertId")
//    void changeIsConfirmed(boolean confirm, int jobAdvertId);
//
//    JobAdvert getJobAdvertById(int id);
//
//    @Transactional
//    void deleteJobAdvertById(int id);

}


