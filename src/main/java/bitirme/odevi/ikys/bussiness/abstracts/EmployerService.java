package bitirme.odevi.ikys.bussiness.abstracts;


import bitirme.odevi.ikys.bussiness.requests.authRequests.EmployerSaveRequest;
import bitirme.odevi.ikys.bussiness.requests.EmployerUpdateRequest;
import bitirme.odevi.ikys.bussiness.requests.authRequests.LoginRequest;
import bitirme.odevi.ikys.bussiness.response.EmployerGetAllResponse;
import bitirme.odevi.ikys.bussiness.response.LoginDataEmployerResponse;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.Employer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmployerService {

    List<EmployerGetAllResponse> employerGetAllResponse();
    Result save(EmployerSaveRequest employerSaveRequest);

    Optional<Employer> findById(int id);

//    List<EmployerJobAdvertisementsRequest> getEmployerByJobAdvertisements();

    Result uploadPicture(int isverenId, MultipartFile file) throws IOException;

    LoginDataEmployerResponse loginEmployer(LoginRequest loginRequest);

    void updateEmployer(int employerId, EmployerUpdateRequest updateRequest);

}
