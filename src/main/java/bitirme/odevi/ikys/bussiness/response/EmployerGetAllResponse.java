package bitirme.odevi.ikys.bussiness.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerGetAllResponse {

    private String email;
    private String password;
    private String passwordAgain;
    private String companyName;
    private String website;
    private String phoneNumber;
    private boolean current;
    private String userType;
}
