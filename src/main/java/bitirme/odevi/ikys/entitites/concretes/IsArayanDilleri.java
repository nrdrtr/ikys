package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseeker_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ozgecmis"})
public class IsArayanDilleri {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "dil_seviyesi")
    @Min(1)
    @Max(5)
    @NotNull
    @NotBlank
    private int dilSeviyesi;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "dil_id")
    private Dil dil;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ozgecmis_id")
    private Ozgecmis ozgecmis;
}
