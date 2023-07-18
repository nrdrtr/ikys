package bitirme.odevi.ikys.bussiness.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerAddFavorite {

    private int jobSeekerId;
    private int jobAdvertisementId;
}
