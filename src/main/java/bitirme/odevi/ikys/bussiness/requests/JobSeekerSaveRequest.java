package bitirme.odevi.ikys.bussiness.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSaveRequest {//ad, soyad, TC Kimlik No, doğum yılı, e-posta, şifre ve şifre tekrarı
    private String name;
    private String surname;
    private String identityNumber;
    private LocalDate birhtDate;
    private String email;
    private String password;
    private String passwordAgain;
}
