package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.JobPositionAddRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobPosition;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobPositionService {
   DataResult<List<JobPosition>> getIsPozisyonu();
   Result addIsPozisyonu(JobPosition jobPosition);

   void  save(JobPositionAddRequest jobPositionAddRequest);
   Page<JobPosition> getJobPositions(int page, int size);
   DataResult<JobPosition> findById(int id);

  // DataResult<List<JobPosition>> findByJobTitleEndsWith(String isIsmi);

}
