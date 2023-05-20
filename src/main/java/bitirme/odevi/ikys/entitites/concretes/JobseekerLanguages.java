package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseeker_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class JobseekerLanguages {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "language_level")
    @Min(1)
    @Max(5)
    @NotNull
    @NotBlank
    private int languageLevel;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;
}
