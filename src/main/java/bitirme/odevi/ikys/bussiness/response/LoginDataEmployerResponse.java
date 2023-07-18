package bitirme.odevi.ikys.bussiness.response;

import bitirme.odevi.ikys.entitites.concretes.Employer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDataEmployerResponse {

    private String message;
    private boolean status;
    private Employer employer;

}
