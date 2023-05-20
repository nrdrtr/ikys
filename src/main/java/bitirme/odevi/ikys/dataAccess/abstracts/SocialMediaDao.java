package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
//    SocialMedia getBySocialMediaByCurriculumVitaeId(int id);

}
