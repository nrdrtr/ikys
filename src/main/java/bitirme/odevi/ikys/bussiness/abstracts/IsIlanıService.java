package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsIlani;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;

import java.util.List;

public interface IsIlanıService {

    DataResult<List<IsIlani>> getAll();
    DataResult<List<IsIlani>> getAllSorted();
    DataResult<List<IsIlani>> getActiveJobAdverts();
    DataResult<IsIlani>  findBySehir(String sehir);
    DataResult<List<IsIlani>> findAllByIsActiveTrue(boolean isDesc);
    DataResult<List<IsIlani>> getAll(int pageNo, int pageSize);
    Result save(IsIlani isIlani);
    List<IsIlani> findByDescriptionStartsWith(String description);
    IsIlani findByDescription(String  description);
    List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails();


}
