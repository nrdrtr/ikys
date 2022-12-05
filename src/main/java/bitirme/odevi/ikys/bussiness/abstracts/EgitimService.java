package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Egitim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EgitimService {

    List<Egitim> egitimGetAll();
    void save(Egitim egitim);

    Page<Egitim> findAllByEgitim(int id, Pageable pageable);
}
