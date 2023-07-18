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
public class EducationRequest {

    private int jobSeekerId;
    private int curriculumVitaeId;
    private int schoolId;
    private int departmentId;
    private LocalDate startDate;
    private LocalDate endDate;
}
