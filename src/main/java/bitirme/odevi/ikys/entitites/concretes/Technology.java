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
@Table(name = "technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class Technology {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "technology_name")
    private String technologyName;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cv_id")
    private CurriculumVitae curriculumVitae;
}
