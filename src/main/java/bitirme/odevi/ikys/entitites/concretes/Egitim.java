package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "egitimler")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ozgecmis"})
public class Egitim {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "baslangic_tarihi")
    @NotNull
    @NotBlank
    private LocalDate baslangicTarihi;

    @Column(name = "bitis_tarihi")
    private LocalDate bitisTarihi;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ozgecmis_id")
    private Ozgecmis ozgecmis;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "okul_id")
    private Okul okul;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bolum_id")
    private Bolum bolum;
}
