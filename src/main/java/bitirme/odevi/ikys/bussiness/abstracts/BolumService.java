package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Bolum;
import java.util.List;

public interface BolumService {
    DataResult<List<Bolum>> getAll();
    Result add(Bolum bolum);
}
 