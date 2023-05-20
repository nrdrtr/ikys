package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.JobAdvertisement;
import bitirme.odevi.ikys.entitites.dto.EmployerWithJobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getAllSorted();
    //aktik iş ilanları
    DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();

    DataResult<JobAdvertisement> findById(int id);
    DataResult<List<JobAdvertisement>>  findBySehir(String sehir);
    DataResult<List<JobAdvertisement>> findAllByIsActiveTrue(boolean isDesc);
    DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);
    Result save(JobAdvertisement jobAdvertisement);
    List<JobAdvertisement> findByDescriptionStartsWith(String description);
    JobAdvertisement findByDescription(String  description);
    List<EmployerWithJobAdvertisementDto> getIsverenWithIsIlanıDetails();
    List<JobAdvertisement> findByIsPozisyonId(int isPozisyonu);



}
