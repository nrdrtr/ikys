package bitirme.odevi.ikys.dataAccess.abstracts;

import bitirme.odevi.ikys.entitites.concretes.IsPozisyonu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IsPozisyonDao extends JpaRepository<IsPozisyonu, Integer> {
    Page<IsPozisyonu> findAll( Pageable pageable);
    IsPozisyonu findById(int id);

    //List<IsPozisyonu> findByJobTitleEndsWith(String isIsmi);


}
