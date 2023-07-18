package bitirme.odevi.ikys.bussiness.requests.authRequests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSaveRequest {

    private String name;
    private String surname;
    private String identityNumber;
    @NotNull
    private LocalDate birthDate;
    private String email;
    private String password;
    private String passwordAgain;
}
