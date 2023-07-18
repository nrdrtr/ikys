package bitirme.odevi.ikys.bussiness.response;


import bitirme.odevi.ikys.entitites.concretes.CurriculumVitae;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerResponse {

    private int id;
    private String message;
    private boolean status;
    private String name;
    private String surname;
    private String email;
    private String identityNumber;
    private LocalDate birthDate;

    private List<CurriculumVitae> curriculumVitaes;

}
