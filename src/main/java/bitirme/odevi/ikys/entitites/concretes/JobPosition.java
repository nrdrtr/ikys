package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "job_positions", uniqueConstraints = {@UniqueConstraint(columnNames = {"job_name"})})
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "job_name")
    @NotNull
    private String jobName;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition",cascade=CascadeType.ALL)
    private List<JobAdvertisement> jobAdvertisement;
}
