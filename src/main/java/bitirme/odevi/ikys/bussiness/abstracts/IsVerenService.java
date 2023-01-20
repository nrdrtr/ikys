package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;

import java.util.List;

public interface IsVerenService {

    List<IsVeren> isVeren();
    void save(IsVeren isVeren);

    List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails();
   // Result add (Image image , MultipartFile multipartFile);
}
