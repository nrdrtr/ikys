package bitirme.odevi.ikys.bussiness.requests.curriculumRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetterAddRequest {

    private int jobSeekerId;
    private int curriculumVitaeId;
    private String description;
}
