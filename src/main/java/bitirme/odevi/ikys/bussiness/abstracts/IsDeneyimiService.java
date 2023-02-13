package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsDeneyimi;

import java.util.List;

public interface IsDeneyimiService {

    DataResult<List<IsDeneyimi>> getIsDeneyimiByOzgecmisId(int id);

    Result add(IsDeneyimi isDeneyimi);

    Result delete(int id);


}
