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
    public DataResult<List<IsIlani>> getActiveJobAdverts() {
        return null;
    }


    @Override
    public DataResult<List<IsIlani>> getAll(int pageNo, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<IsIlani>>
                (this.isIlaniDao.findAll(pageable).getContent());
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


}
