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
@Table(name = "bolumler")
public class Bolum {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "bolum_adi")
    private String bolumAdi;

    @JsonIgnore
    @OneToMany(mappedBy = "bolum", cascade = CascadeType.DETACH)
    private List<Egitim> egitimler;
}
