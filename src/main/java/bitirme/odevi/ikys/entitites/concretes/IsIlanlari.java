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
@Table(name = "is_ilanları")
@Getter
@Setter
public class IsIlanlari {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "isveren_id", referencedColumnName = "kullanıcı_id")
    private IsVerenler isVerenler;

    @OneToOne
    @JoinColumn(name = "sehir_id", referencedColumnName = "sehir_id")
    private Sehirler sehirler;


    @OneToOne(mappedBy = "isIlanlari")
    @JoinColumn(name = "is_pozisyon_id", referencedColumnName = "id")
    private IsPozisyonlari isPozisyonlari;

    @OneToMany(mappedBy = "isIlanlari", cascade = CascadeType.DETACH)
    private  List<Favoriler> favoriler;

    @Column(name = "aciklama")
    private String acıklama;

    @Column(name = "maas")
    private int maas;

    @Column(name = "pozisyon_sayisi")
    private int pozisyonSayisi;

    @Column(name = "yayin_tarihi")
    private Date yayinTarihi;


    @Column(name = "son_tarih")
    private Date sonTarih;

    @Column(name = "calisma_turu")
    private String calismaTuru;


    @Column(name = "calisma_suresi")
    private String calismaSuresi;
}
