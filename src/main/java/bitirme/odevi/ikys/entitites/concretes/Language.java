package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
public class Language {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "language_name")
    private String languageName;

    @JsonIgnore
    @OneToMany(mappedBy = "language", cascade = CascadeType.DETACH)
    private List<JobseekerLanguages> jobseekerLanguages;
}
