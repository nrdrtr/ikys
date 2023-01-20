package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsPozisyonu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IsPozisyonService {
   DataResult<List<IsPozisyonu>> getIsPozisyonu();
   Result addIsPozisyonu(IsPozisyonu isPozisyonu);
   Page<IsPozisyonu> findAll(Pageable pageable);
   DataResult<IsPozisyonu> findById(int id);

  // DataResult<List<IsPozisyonu>> findByJobTitleEndsWith(String isIsmi);

}
