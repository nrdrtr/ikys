package bitirme.odevi.ikys.entitites.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bolumler")
@Getter
@Setter
public class Bolum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bolum_id")
    private int bolumId;


    @Column(name = "bolum_ismi")
    private String bolumIsmi;

    @OneToMany(mappedBy = "bolum",cascade = CascadeType.ALL)
    private List<Egitim> egitim;


}