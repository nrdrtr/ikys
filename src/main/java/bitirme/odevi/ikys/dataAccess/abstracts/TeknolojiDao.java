package bitirme.odevi.ikys.dataAccess.abstracts;
import bitirme.odevi.ikys.entitites.concretes.Teknoloji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TeknolojiDao extends JpaRepository<Teknoloji, Integer> {

    List<Teknoloji> getTeknolojiByOzgecmisId(int id);

    @Transactional
    void deleteTeknolojiById(int id);

}
