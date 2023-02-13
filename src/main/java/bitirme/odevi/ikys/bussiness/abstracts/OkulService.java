package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Okul;

import java.util.List;

public interface OkulService {
    Result addSchool(Okul okul);

    DataResult<List<Okul>>  getAll();
}
