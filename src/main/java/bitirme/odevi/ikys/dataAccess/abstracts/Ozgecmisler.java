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
@Table(name = "ozgecmisler")
@Getter
@Setter
public class Ozgecmisler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "is_arayan_id",referencedColumnName = "kullanıcı_id")
    private IsArayanlar isArayanlar;

    @OneToMany(mappedBy = "ozgecmisler")
    private List<Teknolojiler> teknolojiler;

    @OneToMany(mappedBy = "ozgecmisler")
    private List<Egitimler> egitimler;

    @OneToMany(mappedBy = "ozgecmisler")
    private List<IsArayanDilleri> isArayanDilleri;

    @Column(name = "resim_url")
    private String resimUrl;

    @Column(name = "on_yazi")
    private String onYazi;

    @OneToMany(mappedBy = "ozgecmisler")
    private List<IsDeneyimleri> isDeneyimleri;
}
