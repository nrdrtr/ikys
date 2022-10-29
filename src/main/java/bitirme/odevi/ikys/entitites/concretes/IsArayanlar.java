package bitirme.odevi.ikys.entitites.concretes;

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
public class IsArayanlar extends Kullanıcılar {



    @Column(name = "adi")
    private String adi;

    @Column(name = "soyadi")
    private String soyadi;

    @Column(name = "kimlik_numarası")
    private String kimlikNumarasi;

    @Column(name = "dogum_tarihi")
    private Date dogumTarihi;

    @OneToOne(mappedBy = "isArayanlar")
    private Ozgecmisler ozgecmisler;

    @OneToMany(mappedBy = "isArayanlar")
    private List<Favoriler> favoriler;

}
