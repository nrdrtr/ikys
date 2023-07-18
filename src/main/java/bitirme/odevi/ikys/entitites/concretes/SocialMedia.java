package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "social_medias")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeeker"})
public class SocialMedia {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "social_media_name")
    private String socialMediaName;

//
//    @JsonIgnoreProperties({"firstName", "surname", "email", "password", "identityNumber", "birthDate"})
//    @ManyToOne()
//    @JoinColumn(name = "jobseeker_id")
//    private JobSeeker jobSeeker;

    //@OneToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "cv_id")
//    private CurriculumVitae curriculumVitae;

}
