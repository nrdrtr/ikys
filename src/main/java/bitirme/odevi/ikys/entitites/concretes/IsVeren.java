package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "isverenler", uniqueConstraints = {@UniqueConstraint(columnNames = {"sirket_adi"})})
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "kullanici_id", referencedColumnName = "id")
public class IsVeren extends User {

    @Column(name = "sirket_adi")
    @NotNull
    private String  sirketAdi;

    @Column(name = "website")
    @NotNull
    private String website;

    @Column(name = "telefon_numarasi")
    @NotNull
    private String  telefonNumarasi;

    @Column(name = "guncel_mi")
    private boolean guncelMi = false;

    @JsonIgnore
    @OneToMany(mappedBy = "isveren")
    private List<IsIlani> isIlani;
}