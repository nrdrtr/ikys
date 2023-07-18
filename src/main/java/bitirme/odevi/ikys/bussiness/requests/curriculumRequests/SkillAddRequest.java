package bitirme.odevi.ikys.bussiness.requests.curriculumRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillAddRequest {
    private String programmingLanguage;
    private String technologyName;
    private int curriculumVitaeId;
    private int jobSeekerId;

}
