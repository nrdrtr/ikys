package bitirme.odevi.ikys.bussiness.response;

import bitirme.odevi.ikys.entitites.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDataJobSeekerResponse {
    private String message;
    private boolean status;
    private JobSeeker jobSeeker;

}
