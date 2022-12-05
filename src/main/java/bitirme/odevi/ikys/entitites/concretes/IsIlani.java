package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favorites"})

public class IsIlani {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "description")
    @NotNull
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    @Column(name = "salary")
    @NotNull
    private int salary;

    @Column(name = "position_count")
    @NotNull
    private int positionCount;

    @Column(name = "deadline")
    @NotNull
    private LocalDate deadline;

    @Column(name = "airdate")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime airdate = LocalDateTime.now();

    @Column(name = "uptime")
    @NotNull
    private String upTime;

    @Column(name = "type_of_employment")
    @NotNull
    private String typeOfEmployment;

    @Column(name = "is_active")
    @NotNull
    private boolean isActive = true;

    @Column(name = "is_confirmed")
    @NotNull
    private boolean isConfirmed = false;

    @ManyToOne()
    @JoinColumn(name = "isveren_id")
    private IsVeren  isveren;

    @ManyToOne
    @JoinColumn(name = "is_pozisyonu_id")
    private IsPozisyonu isPozisyonu;

    @ManyToOne()
    @JoinColumn(name = "sehir_id")
    private Sehir sehir;

    @OneToMany(mappedBy = "isIlani", cascade = CascadeType.DETACH)
    private List<Favori> favoriler;
}