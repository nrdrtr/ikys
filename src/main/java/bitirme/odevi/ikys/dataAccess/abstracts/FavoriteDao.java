package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FavoriteDao extends JpaRepository<Favorite,Integer> {

    List<Favorite> getFavoriteByJobSeekerId(int id);

    Favorite findByJobSeekerIdAndJobAdvertisementId(int jobSeekerId, int jobAdvertisementId);
//  List<Favori> getFavoriByIsArayanId(int id);
//    List<Favorite> getFavoriteByJobSeekerId(int id);
//
//    @Transactional
//    void deleteFavoriteByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId);

}




