package bitirme.odevi.ikys.bussiness.requests;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerSaveRequest {///şirket adı, web sitesi, e-posta, telefon, şifre ve şifre tekrarı bilgileri

        @NotNull
        private String companyName;
        @NotNull
        private String website;
        @NotNull
        private String email;
        @NotNull
        private String phoneNumber;
        @NotNull
        private String password;
        @NotNull
        private String passwordAgain;
}
