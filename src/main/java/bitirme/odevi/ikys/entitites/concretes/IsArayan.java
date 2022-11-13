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
@Table(name = "is_arayanlar")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "kullanıcı_id", referencedColumnName = "kullanıcı_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ozgecmis", "favori"})
public class IsArayan extends Kullanıcı {

    @Column(name = "adi")
    private String adi;

    @Column(name = "soyadi")
    private String soyadi;

    @Column(name = "kimlik_numarası")
    private String kimlikNumarasi;

    @Column(name = "dogum_tarihi")
    private Date dogumTarihi;

    @OneToOne(mappedBy = "isArayan")
    private Ozgecmis ozgecmis;

    @OneToMany(mappedBy = "isArayan")
    private List<Favori> favori;

}
