package bitirme.odevi.ikys.bussiness.requests.curriculumRequests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceRequest {


    private String companyName;
    private String positionName;
    private LocalDate startDate;
    private LocalDate endDate;
    private int curriculumVitaeId;
    private int jobSeekerId;
}
