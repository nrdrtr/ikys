package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "is_deneyimleri")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ozgecmis"})

public class IsDeneyimi {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "sirket_adi")
    private String sirketAdi;

    @Column(name = "pozisyon_adi")
    private String pozisyonAdi;

    @Column(name = "baslangic_tarihi")
    @NotNull

    private LocalDate baslangicTarihi;

    @Column(name = "bitis_tarihi")
    private LocalDate bitisTarihi;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ozgecmis_id")
    private Ozgecmis ozgecmis;
}



