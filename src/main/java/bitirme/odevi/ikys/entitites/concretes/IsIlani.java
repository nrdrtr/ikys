package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "is_ilanlari")
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "favoriler"})

public class IsIlani {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "aciklama")
    @NotNull
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    @Column(name = "maas")
    @NotNull
    private int maas;

    @Column(name = "pozisyon_sayisi")
    @NotNull
    private int pozisyonSayisi;

    @Column(name = "bitis_tarihi")
    @NotNull
    private LocalDate bitisTarihi;

    @Column(name = "yayin_tarihi")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate  yayinTarihi;

    @Column(name = "calisma_zamani")
    @NotNull
    private String calismaZamani;

    @Column(name = "calisma_turu")
    @NotNull
    private String calismaTuru;

    @Column(name = "aktif_mi")
    @NotNull
    private boolean aktifMi ;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "isveren_id")
    private IsVeren  isveren;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "is_pozisyonu_id")
    private IsPozisyonu isPozisyonu;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sehir_id")
    private Sehir sehir;

    @OneToMany(mappedBy = "isIlani", cascade = CascadeType.DETACH)
    private List<Favori> favoriler;
}