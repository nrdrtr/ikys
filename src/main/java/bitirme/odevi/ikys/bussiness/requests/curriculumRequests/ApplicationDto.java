package bitirme.odevi.ikys.bussiness.requests.curriculumRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private String jobSeekerName;
    private String jobSeekerSurname;
    private LocalDate jobSeekerBirthDate;
    private String jobSeekerIdentityNumber;
}
