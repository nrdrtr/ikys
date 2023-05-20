package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "jobseekers", uniqueConstraints = {@UniqueConstraint(columnNames = {"identity_number"})})
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favorites","curriculumVitaes"})
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

    @Column(name = "user_type")
    private String userType;

    @Column(name = "birth_date")
    @NotNull
    private LocalDate birhtDate;



    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
    private List<CurriculumVitae> curriculumVitaes;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.DETACH)
    private List<Favorite> favorites;
}