package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.City;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();

}
