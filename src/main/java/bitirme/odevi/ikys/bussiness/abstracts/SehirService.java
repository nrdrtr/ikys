package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.Sehir;

import java.util.List;

public interface SehirService {

    DataResult<List<Sehir>> getAll();

}
