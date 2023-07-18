package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "jobseekers", uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_number"})})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favorites", "applications", "curriculumVitaes"})
public class JobSeeker extends User {

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "identity_number")
    @NotNull
    private String identityNumber;

    @Column(name = "birth_date")
    @NotNull
    private LocalDate birthDate;

    @OneToMany(mappedBy = "jobSeeker", fetch = FetchType.LAZY)
    private List<Application> applications;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
    private List<CurriculumVitae> curriculumVitaes;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
    private List<Favorite> favorites;


}