package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favorites", "applications"})
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "explanation")
    @NotNull
    private String explanation;

    @Column(name = "salary")
    private int salary;

    @Column(name = "number_of_open_positions")
    private int  numberOfOpenPositions;

    @Column(name = "end_date")
    @NotNull
    private LocalDate endDate;

    @Column(name = "release_date")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate  releaseDate;

    @Column(name = "work_time")
    private String workTime;

    @Column(name = "work_type")
    private String workType;

    @Column(name = "active")
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


    @OneToMany(mappedBy = "jobAdvertisement",  fetch = FetchType.EAGER)
    private List<Application> applications;


    @OneToMany(mappedBy = "jobAdvertisement", cascade = CascadeType.DETACH)
    private List<Favorite> favorites;
}