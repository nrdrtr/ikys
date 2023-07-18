package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.requests.UserSaveRequest;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {
    DataResult<List<User>> getAll();

    DataResult<User> getById(int id);

    DataResult<User> getByEmail(String email);

    User saveUser(UserSaveRequest userSaveRequest);

    ResponseEntity<?> confirmEmail(String confirmationToken);

}
