package bitirme.odevi.ikys.bussiness.requests.curriculumRequests;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyUpdateDto {
    private int id;
    private int curriculaVitaeId;
    private String plName;
}
