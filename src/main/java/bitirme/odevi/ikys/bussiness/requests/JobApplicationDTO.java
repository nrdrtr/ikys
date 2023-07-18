package bitirme.odevi.ikys.bussiness.requests;

import bitirme.odevi.ikys.bussiness.requests.curriculumRequests.ApplicationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationDTO {
    private int jobAdvertisementId;
    private String jobAdvertisementExplanation;
    private String jobAdvertisementCompanyName;
    private List<ApplicationDto> applications;

}
