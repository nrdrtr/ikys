package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "curriculumVitae"})
public class Education {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "start_date")
    @NotNull
    @NotBlank
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "department_id")
    private Department department;
}
