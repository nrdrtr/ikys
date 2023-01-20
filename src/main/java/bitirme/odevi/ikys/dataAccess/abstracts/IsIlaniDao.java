package bitirme.odevi.ikys.dataAccess.abstracts;



import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.IsIlani;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IsIlaniDao extends JpaRepository<IsIlani, Integer> {


//    DataResult<List<IsIlani>> findAllByIsActiveTrue();

    //DataResult<List<IsIlani>> findByAllAktifMiTrue(Sort sort);

    List<IsIlani> findByDescriptionStartsWith(String description);

    IsIlani findByDescription(String  description);


    @Query("Select new bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto"+
            "(p.id, v.sirketAdi, p.description)" +
            " From IsVeren v Inner Join  v.isIlani p")//JPQL (Java Persistence Query Language) sorguları yazıyoruz.     //JPQL sorguları SQL sorgularına çevrilir.
    List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails();



}


