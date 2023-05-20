package bitirme.odevi.ikys.dataAccess.abstracts;


import bitirme.odevi.ikys.entitites.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SehirDao extends JpaRepository<City, Integer> {



}

