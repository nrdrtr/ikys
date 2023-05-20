package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.bussiness.requests.EmployerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.LoginMessage;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Employer;
import bitirme.odevi.ikys.entitites.dto.EmployerWithJobAdvertisementDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployerService {

    List<Employer> isVeren();
    void save(EmployerSaveRequest employerSaveRequest);

    List<EmployerWithJobAdvertisementDto> getIsverenWithIsIlanıDetails();

    Result uploadPicture(int isverenId, MultipartFile file) throws IOException;

    LoginMessage loginEmployer(LoginRequest loginRequest);

}
