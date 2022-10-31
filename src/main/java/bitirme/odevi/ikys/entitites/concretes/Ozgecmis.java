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
public class Ozgecmis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "is_arayan_id",referencedColumnName = "kullanıcı_id")
    private IsArayan isArayan;

    @OneToMany(mappedBy = "ozgecmis")
    private List<Teknoloji> teknoloji;

    @OneToMany(mappedBy = "ozgecmis")
    private List<Egitim> egitim;

    @OneToMany(mappedBy = "ozgecmis")
    private List<IsArayanDilleri> isArayanDilleri;

    @OneToMany(mappedBy = "ozgecmis")
    private List<SosyalMedya> sosyalMedya;

    @Column(name = "resim_url")
    private String resimUrl;

    @Column(name = "on_yazi")
    private String onYazi;

    @OneToMany(mappedBy = "ozgecmis")
    private List<IsDeneyimi> isDeneyimi;
}
