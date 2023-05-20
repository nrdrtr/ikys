package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favorites"})
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "explanation")
    @NotNull
    private String explanation;

    @Column(name = "salary")
    @NotNull
    private int salary;

    @Column(name = "number_of_open_positions")
    @NotNull
    private int  numberOfOpenPositions;

    @Column(name = "end_date")
    @NotNull
    private LocalDate endDate;

    @Column(name = "release_date")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate  releaseDate;

    @Column(name = "work_time")
    @NotNull
    private String workTime;

    @Column(name = "work_type")
    @NotNull
    private String workType;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "jobAdvertisement", cascade = CascadeType.DETACH)
    private List<Favorite> favorites;
}