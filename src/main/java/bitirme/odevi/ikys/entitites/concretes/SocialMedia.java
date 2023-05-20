package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "social_medias")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class SocialMedia {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "github_username")
    private String githubUsername;

    @Column(name = "linkedin_username")
    private String linkedinUsername;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;
}
