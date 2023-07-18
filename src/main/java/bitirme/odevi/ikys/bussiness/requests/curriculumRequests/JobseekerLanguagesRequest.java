package bitirme.odevi.ikys.bussiness.requests.curriculumRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobseekerLanguagesRequest {

    private int languageLevel;
    private int languageId;
    private int curriculumVitaeId;
    private int jobSeekerId;
}
