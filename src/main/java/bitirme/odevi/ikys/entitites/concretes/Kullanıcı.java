package bitirme.odevi.ikys.entitites.concretes;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kullanicilar", uniqueConstraints = {@UniqueConstraint(columnNames = {"e_posta"})})
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Kullanıcı {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
     private int id;

    @NotNull
    @Column(name = "e_posta")
    private String  ePosta;

    @NotNull
    @Column(name = "sifre")
     private String sifre;

    @NotNull
    @Column(name = "sifre_tekrari")
     private String sifreTekrari;


    @Column(name = "aktif_mi")
    private boolean  aktifMi = false;


}
