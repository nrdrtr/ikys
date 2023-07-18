package bitirme.odevi.ikys.bussiness.concretes;


import bitirme.odevi.ikys.bussiness.abstracts.ApplicationService;
import bitirme.odevi.ikys.bussiness.abstracts.JobAdvertisementService;
import bitirme.odevi.ikys.bussiness.requests.EmployerJobAdvertisementsRequest;
import bitirme.odevi.ikys.bussiness.requests.JobApplicationDTO;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.ApplicationDao;
import bitirme.odevi.ikys.dataAccess.abstracts.JobAdvertisementDao;
import bitirme.odevi.ikys.entitites.concretes.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private ModelMapperService modelMapperService;


    @Override
    public List<JobApplicationDTO> getApplicantsByJobAdvertisement(int id) {
        JobAdvertisement jobAdvertisement = jobAdvertisementDao.findById(id);

        if (jobAdvertisement == null) {

            return new ArrayList<>();
        }

        List<JobApplicationDTO> applicants = new ArrayList<>();
        List<Application> applications = jobAdvertisement.getApplications();

        for (Application application : applications) {

            try {
                JobApplicationDTO dto = this.modelMapperService.forRequest().map(application.getJobSeeker(), JobApplicationDTO.class);
                applicants.add(dto);
            } catch (Exception e) {
                // Hata mesajını ve ayrıntılarını yazdırabilir veya loglayabilirsiniz
                e.printStackTrace();
            }


        }

        return applicants;
    }


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
    public List<JobAdvertisement> findByEmployerId(int employerId) {
        return this.jobAdvertisementDao.findByEmployerId(employerId);
    }



    @Override
    public Result save(EmployerJobAdvertisementsRequest employerJobAdvertisementsRequest) throws Exception {

        JobAdvertisement advertisement = this.modelMapperService.forRequest().map(employerJobAdvertisementsRequest, JobAdvertisement.class);
        System.out.print("------------------" + advertisement.getEmployer());

        this.jobAdvertisementDao.save(advertisement);
        return new SuccessResult("Data Kaydedildi");

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
    public List<JobAdvertisement> findByCityName(String cityName) {
        return this.jobAdvertisementDao.findByCityName(cityName);
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
    public Result setStatus(int jobAdvertisementId, int employerId, boolean status) {
        List<JobAdvertisement> jobAdvertisements = this.jobAdvertisementDao.findByEmployerId(employerId);

        for(JobAdvertisement jobAdvertisement:jobAdvertisements) {
            if(jobAdvertisementId == jobAdvertisement.getId()) {
                jobAdvertisement.setActive(status);
                this.jobAdvertisementDao.save(jobAdvertisement);
                return new SuccessResult("Statü değiştirildi");
            }
        }

        return null;
    }

//    @Override
//    public Result save(JobAdvertisement jobAdvertisement) {
//        this.jobAdvertisementDao.save(jobAdvertisement);
//        return new SuccessResult("İş ilanı eklendi");
//    }

    @Override
    public List<JobAdvertisement> findByDescriptionStartsWith(String explanation) {
        return this.jobAdvertisementDao.findByExplanationStartsWith(explanation);
    }

    @Override
    public List<JobAdvertisement> findByIsPozisyonId(int isPozisyonu) {
        return this.jobAdvertisementDao.findByJobPositionId(isPozisyonu);
    }
}
