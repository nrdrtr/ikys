package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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



    @OneToOne(mappedBy = "diller")
    private IsArayanDilleri isArayanDilleri;


}
