package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "is_arayanlar", uniqueConstraints = {@UniqueConstraint(columnNames = {"kimlik_numarasi"})})
@PrimaryKeyJoinColumn(name = "kullanici_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ozgecmis", "favoriler"})
public class IsArayan extends Kullanıcı {

    @Column(name = "adi")
    @NotNull
    private String adi;

    @Column(name = "soyadi")
    @NotNull
    private String  soyadi;

    @Column(name = "kimlik_numarasi")
    @NotNull
    private String  kimlikNumarasi;

    @Column(name = "dogum_tarihi")
    @NotNull
    private LocalDate  dogumTarihi;

    @JsonIgnore
    @OneToMany(mappedBy = "isArayan", cascade = CascadeType.DETACH)
    private List<Ozgecmis> ozgecmis;

    @OneToMany(mappedBy = "isArayan", cascade = CascadeType.DETACH)
    private List<Favori> favoriler;
}