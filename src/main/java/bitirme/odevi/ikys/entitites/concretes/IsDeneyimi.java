package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "is_deneyimleri")
@Getter
@Setter
public class IsDeneyimi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ozgecmis_id",referencedColumnName = "id")
    private Ozgecmis ozgecmis;

    @Column(name = "sirket_adi")
    private String sirketAdi;

    @Column(name = "pozisyon_adi")
    private String pozisyonAdi;

    @Column(name = "baslangic_tarihi")
    private Date baslangicTarihi;

    @Column(name = "bitis_tarihi")
    private Date bitisTarihi;




}
