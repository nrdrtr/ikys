package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.Favori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface FavoriDao extends JpaRepository<Favori,Integer> {

    List<Favori> getFavoriteByIsArayanId(int id);

//    @Transactional
//    void deleteFavoriteByIsArayanIdAndIsIlaniId(int id);

}




