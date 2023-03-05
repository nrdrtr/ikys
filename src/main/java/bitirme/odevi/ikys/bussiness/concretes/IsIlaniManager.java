package bitirme.odevi.ikys.bussiness.concretes;


import bitirme.odevi.ikys.bussiness.abstracts.IsIlanıService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.IsIlaniDao;
import bitirme.odevi.ikys.entitites.concretes.IsIlani;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsIlaniManager implements IsIlanıService {


    private IsIlaniDao isIlaniDao;

    @Autowired
    public IsIlaniManager(IsIlaniDao isIlaniDao) {
        this.isIlaniDao = isIlaniDao;
    }

    @Override
    public DataResult<List<IsIlani>> getAll() {

        if (this.isIlaniDao.findAll().isEmpty()) {
            return new SuccessDataResult<List<IsIlani>>(this.isIlaniDao.findAll(), "İş ilanları listelendi");
        } else {
            return new ErrorDataResult<>(this.isIlaniDao.findAll(), "mevcutta iş ilanı bulunmamaktadır");
        }

    }

    @Override
    public DataResult<List<IsIlani>> getAllSorted() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return new SuccessDataResult<>(this.isIlaniDao.findAll(sort), "iş ilanları pozisyon sayısına göre sıralandı");

    }

    @Override
    public DataResult<IsIlani> findById(int id) {
        return new SuccessDataResult<IsIlani>(this.isIlaniDao.findById(id), "iş ilanı id bazlı getirildi");
    }

    @Override
    public DataResult<List<IsIlani>> getActiveJobAdverts() {
        return null;
    }

    @Override
    public DataResult<IsIlani> findBySehir(String sehir) {
        return new SuccessDataResult<IsIlani>(this.isIlaniDao.findBySehir(sehir), "şehir bazlı iş ilanları listelendi");
    }


    @Override
    public DataResult<List<IsIlani>> getAll(int pageNo, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<IsIlani>>
                (this.isIlaniDao.findAll(pageable).getContent());
    }


    @Override
    public DataResult<List<IsIlani>> findAllByIsActiveTrue(boolean isDesc) {

        Sort sort;
        if (isDesc) {
            sort = Sort.by(Sort.Direction.DESC, "yayinTarihi");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "yayinTarihi");
        }

        if ((long) this.isIlaniDao.findAllByAktifMiTrue(sort).size() > 0) {
            return new SuccessDataResult<>(
                    this.isIlaniDao.findAllByAktifMiTrue(sort),
                    "Aktif tüm iş ilanları yayınlanma tarihine göre listelendi!");
        }
        return new ErrorDataResult<>(
                this.isIlaniDao.findAllByAktifMiTrue(sort),
                "Aktif iş ilanı bulunamadı!");
    }

    @Override
    public Result save(IsIlani isIlani) {
        this.isIlaniDao.save(isIlani);
        return new SuccessResult("İş ilanı eklendi");
    }

    @Override
    public List<IsIlani> findByDescriptionStartsWith(String description) {
        return this.isIlaniDao.findByDescriptionStartsWith(description);
    }

    @Override
    public IsIlani findByDescription(String description) {
        return this.isIlaniDao.findByDescription(description);
    }

    @Override
    public List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails() {
        return this.isIlaniDao.getIsverenWithIsIlanıDetails();
    }

    @Override
    public List<IsIlani> findByIsPozisyonId(int isPozisyonu) {
        return this.isIlaniDao.findByIsPozisyonuId(isPozisyonu);
    }
}
