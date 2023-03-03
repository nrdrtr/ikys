package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IsVerenService {

    List<IsVeren> isVeren();
    void save(IsVeren isVeren);

    List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails();

    Result uploadPicture(int isverenId, MultipartFile file) throws IOException;

}
