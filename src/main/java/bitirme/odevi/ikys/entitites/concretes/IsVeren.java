package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "isverenler")
@PrimaryKeyJoinColumn(name = "kullanıcı_id", referencedColumnName = "kullanıcı_id")
public class IsVeren extends Kullanıcı {



    @Column(name = "sirket_adi")
    private String sirketAdi;
    @Column(name = "web_sitesi")
    private String webSite;
    @Column(name = "telefon_numarasi")
    private String telefonNumarasi;
    @Column(name = "resim_url")
    private String resimUrl;
    @Column(name = "is_uptadated")
    private boolean isUptated;
    @Column(name = "sifre")
    private String sifre;
    @Column(name = "sifre_tekrari")
    private String sifreTekrar;

    @OneToMany(mappedBy = "isVeren")
    private List<IsIlani> isIlani;

}
