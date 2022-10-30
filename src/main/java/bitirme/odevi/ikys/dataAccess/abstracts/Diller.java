package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diller")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Diller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dil_id")
    private int dilId;
    @Column(name = "dil_ismi")
    private String dilAdi;
    @Column(name = "dil_seviyesi")
    private String dilSeviye;



    @OneToMany(mappedBy = "diller", cascade = CascadeType.DETACH)
    private List<IsArayanDilleri> isArayanDilleri;


}
