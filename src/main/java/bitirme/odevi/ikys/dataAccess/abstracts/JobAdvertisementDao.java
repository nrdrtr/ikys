package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    //ilanlarını konum, aktiflik, çalışma türü (yarı zamanlı vb.) job postings by city
//    @Query("SELECT i FROM Ilanlar i \n" +
//            "JOIN i.sehir s \n" +
//            "WHERE s.sehirAd = :sehirAd\n")
//    List<JobAdvertisement>  jobPostingsByCity(String sehir_id);//şehre göre ilan getirme

//    @Query("Select new bitirme.odevi.ikys.entitites.dto.EmployerWithJobAdvertisementDto"+
//            "(p.id, v.sirketAdi, p.description)" +
//            " From Employer v Inner Join  v.isIlani p")//JPQL (Java Persistence Query Language) sorguları yazıyoruz.     //JPQL sorguları SQL sorgularına çevrilir.
 // List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails();
   ///List<EmployerWithJobAdvertisementDto> getEmployerWithJobAdvertisementDetails();
    JobAdvertisement findById(int id);

    List<JobAdvertisement> findAllByActiveTrue(Sort sort);

    List<JobAdvertisement> findByExplanationStartsWith(String explanation);

    JobAdvertisement findByExplanation(String  explanation);

 // ilanları aktiflik durumuna göre listeleme
    List<JobAdvertisement> findAllByActiveTrue();//    List<JobAdvert> findAllByIsActiveTrue(Sort sort);
    List<JobAdvertisement> findByJobPositionId(int job_position_id);//bir iş poziyonuna ait tüm iş ilanlarını getirir.


//    @Query("SELECT j FROM JobAdvertisement j WHERE j.isPozisyonu = :isPozisyonu")//SELECT * FROM is_ilanlari WHERE is_pozisyonu_id = 5;
//    List<JobAdvertisement> getIsIlaniByIsPozisyonuId(@Param("isPozisyonu") int isPozisyonuId); sonsuz döndü


//
//    List<JobAdvert> getJobAdvertByEmployer_CompanyName(String companyName, Sort sort);
//
//    List<JobAdvert> getJobAdvertByEmployerId(int employerId, Sort sort);
//    ısActive
//

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


