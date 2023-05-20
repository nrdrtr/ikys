package bitirme.odevi.ikys.bussiness.concretes;


import bitirme.odevi.ikys.bussiness.abstracts.JobAdvertisementService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.JobAdvertisementDao;
import bitirme.odevi.ikys.entitites.concretes.JobAdvertisement;
import bitirme.odevi.ikys.entitites.dto.EmployerWithJobAdvertisementDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {

        if (this.jobAdvertisementDao.findAll().isEmpty()) {
            return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "İş ilanları listelendi");
        } else {
            return new ErrorDataResult<>(this.jobAdvertisementDao.findAll(), "mevcutta iş ilanı bulunmamaktadır");
        }

    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSorted() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return new SuccessDataResult<>(this.jobAdvertisementDao.findAll(sort), "iş ilanları pozisyon sayısına göre sıralandı");

    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByActiveTrue(), "aktif iş ilanları listelendi");
    }

    @Override
    public DataResult<JobAdvertisement> findById(int id) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id), "iş ilanı id bazlı getirildi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findBySehir(String sehir) {
        return null;
            //    new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findBysehir_id(sehir), "şehir bazlı iş ilanları listelendi");
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findAll(pageable).getContent());
    }


    @Override
    public DataResult<List<JobAdvertisement>> findAllByIsActiveTrue(boolean isDesc) {

        Sort sort;
        if (isDesc) {
            sort = Sort.by(Sort.Direction.DESC, "releaseDate");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "releaseDate");
        }

        if ((long) this.jobAdvertisementDao.findAllByActiveTrue(sort).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertisementDao.findAllByActiveTrue(sort),
                    "Aktif tüm iş ilanları yayınlanma tarihine göre listelendi!");
        }
        return new ErrorDataResult<>(
                this.jobAdvertisementDao.findAllByActiveTrue(sort),
                "Aktif iş ilanı bulunamadı!");
    }

    @Override
    public Result save(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public List<JobAdvertisement> findByDescriptionStartsWith(String explanation) {
        return this.jobAdvertisementDao.findByExplanationStartsWith(explanation);
    }

    @Override
    public JobAdvertisement findByDescription(String explanation) {
        return this.jobAdvertisementDao.findByExplanation(explanation);
    }

    @Override
    public List<EmployerWithJobAdvertisementDto> getIsverenWithIsIlanıDetails() {
        return null;
                //this.jobAdvertisementDao.getIsverenWithIsIlanıDetails();
    }

    @Override
    public List<JobAdvertisement> findByIsPozisyonId(int isPozisyonu) {
        return this.jobAdvertisementDao.findByJobPositionId(isPozisyonu);
    }
}
