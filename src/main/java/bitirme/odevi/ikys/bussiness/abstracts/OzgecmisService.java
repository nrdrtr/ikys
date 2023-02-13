package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Ozgecmis;
import bitirme.odevi.ikys.entitites.dto.OzgecmisAddDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface OzgecmisService {


    Result addOzgecmis(OzgecmisAddDto ozgecmis);

    Result updateOzgecmis(OzgecmisAddDto ozgecmis);

    DataResult<Ozgecmis> findByJobSeekerId(int isArayanId);
    Result uploadPicture(int cvId, MultipartFile file) throws IOException;


}
