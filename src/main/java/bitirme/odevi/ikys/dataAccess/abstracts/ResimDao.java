package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResimDao extends JpaRepository<Image, Integer> {

    Image getByUserId(int userId);



}
