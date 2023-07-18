package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.EmployerJobAdvertisementsRequest;
import bitirme.odevi.ikys.bussiness.requests.JobApplicationDTO;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getAllSorted();
    List<JobAdvertisement> findByEmployerId(int employerId);
    List<JobApplicationDTO> getApplicantsByJobAdvertisement(int id);

    Result save(EmployerJobAdvertisementsRequest employerJobAdvertisementsRequest) throws Exception;

    DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();
    DataResult<List<JobAdvertisement>> findAllByIsActiveTrue(boolean isDesc);

    Result setStatus(int jobAdvertisementId, int employerId, boolean status);

    DataResult<JobAdvertisement> findById(int id);
    List<JobAdvertisement> findByCityName(String cityName); // DataResult<List<JobAdvertisement>>  findBySehir(String sehir);
    DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);
//    Result save(JobAdvertisement jobAdvertisement);
    List<JobAdvertisement> findByDescriptionStartsWith(String description);

    List<JobAdvertisement> findByIsPozisyonId(int isPozisyonu);



}
