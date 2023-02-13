package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.Dil;

import java.util.List;

public interface IDillerService  {
    DataResult<List<Dil>> getDiller();
    DataResult<List<Dil>> add(List<Dil> diller);
}
