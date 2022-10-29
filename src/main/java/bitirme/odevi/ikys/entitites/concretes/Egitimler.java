package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "egitimler")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ozgecmisler"})

public class Egitimler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ozgecmis_id",referencedColumnName = "id")
    private Ozgecmisler ozgecmisler;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "okul_id",referencedColumnName = "okul_id")
    private Okullar okullar;


    @ManyToOne
    @JoinColumn(name="bolum_id",referencedColumnName ="bolum_id" )
    private Bolumler bolumler;


    @Column(name = "baslangic_tarihi")
    private Date baslangicTarihi;
    @Column(name = "bitis_tarihi")
    private Date bitisTarihi;
}
