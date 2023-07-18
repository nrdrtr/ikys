package bitirme.odevi.ikys.entitites.concretes;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee_social_medias")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class JobSeekerSocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="social_media_id")
    private SocialMedia socialMedia;

    @Column(name="social_media_adress")
    private String socialMediaAdress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;

    @JsonIgnoreProperties({"firstName","surname","email","password","identityNumber","birthDate"})
    @ManyToOne()
    @JoinColumn(name = "jobseeker_id")
    private JobSeeker jobSeeker;

}
