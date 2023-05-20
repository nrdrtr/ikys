package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @JsonIgnore
    @OneToMany(mappedBy = "school", cascade = CascadeType.DETACH)
    private List<Education> educations;
}
