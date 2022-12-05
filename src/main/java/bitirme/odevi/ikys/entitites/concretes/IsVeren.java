package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "isverenler", uniqueConstraints = {@UniqueConstraint(columnNames = {"sirket_adi"})})
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "kullanici_id", referencedColumnName = "id")
public class IsVeren extends Kullanıcı {

    @Column(name = "sirket_adi")
    @NotNull
    private String  sirketAdi;

    @Column(name = "website")
    @NotNull
    private String website;

    @Column(name = "telefon_numarasi")
    @NotNull
    private String  telefonNumarasi;

    @Column(name = "resim_url")
    private  String resimUrl;
//    private String pictureUrl = "https://res.cloudinary.com/torukobyte/image/upload/v1623515256/customer_rca6tq.png";

    @Column(name = "is_updated")
    private boolean isUpdated = false;


    @JsonIgnore
    @OneToMany(mappedBy = "isveren")
    private List<IsIlani> isIlani;
}