package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Egitim;

import java.util.List;

public interface EgitimService {

    DataResult<List<Egitim>> egitimGetAll();

    DataResult<List<Egitim>> egitimGetEgitimByOzgecmisId(int id);

    Result save(Egitim egitim);

    Result deleteEgitimById(int id);


}
