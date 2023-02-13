package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.IsDeneyimi;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IsDeneyimiDao extends JpaRepository<IsDeneyimi, Integer> {

    List<IsDeneyimi> getIsDeneyimiBitisTarihiByOzgecmis(int id, Sort sort);
    @Transactional
    void deleteIsDeneyimiById(int id);

}



