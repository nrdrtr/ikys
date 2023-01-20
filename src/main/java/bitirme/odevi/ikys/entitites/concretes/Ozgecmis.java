package bitirme.odevi.ikys.entitites.concretes;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ozgecmisler")
public class Ozgecmis {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "on_yazi")
    private String onYazi;

    @Column(name = "resim_url")
    private String resimUrl;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "is_arayan_id")
    private IsArayan isArayan;

    @OneToOne(mappedBy = "ozgecmis", cascade = CascadeType.DETACH)
    private SosyalMedya sosyalMedya;

    @OneToMany(mappedBy = "ozgecmis", cascade = CascadeType.DETACH)
    private List< Egitim> egitimler;

    @OneToMany(mappedBy = "ozgecmis", cascade = CascadeType.DETACH)
    private List<IsDeneyimi> isDeneyimleri;

    @OneToMany(mappedBy = "ozgecmis", cascade = CascadeType.DETACH)
    private List<IsArayanDilleri> isArayanDilleri;

    @OneToMany(mappedBy = "ozgecmis", cascade = CascadeType.DETACH)
    private List<Teknoloji> teknolojiler;
}
