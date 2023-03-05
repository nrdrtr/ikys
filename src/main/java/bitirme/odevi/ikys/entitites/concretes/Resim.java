package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resimler")
public class Resim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "public_id")
    private String publicId;


    @Column(name = "resim_url")
    private String url;

    @OneToOne
    @JoinColumn(name = "kullanıcı_id")
    private Kullanıcı kullanıcı;


}
