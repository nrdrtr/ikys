package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "okullar")
@Getter
@Setter
public class Okul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "okul_id")
    private int okulId;

    @Column(name = "okul_adi")
    private String okulAdi;

    @ManyToOne()
    private Bolum bolum;

    @OneToMany(mappedBy = "okul")
    private List<Egitim> egitim;

}
