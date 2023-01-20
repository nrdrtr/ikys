package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sosyal_medyalar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ozgecmis"})
public class SosyalMedya {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "github_kullanici_adi")
    private String githubKullaniciAdi;

    @Column(name = "linkedin_kullanici_adi")
    private String linkedinKullaniciAdi;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ozgecmis_id")
    private Ozgecmis ozgecmis;
}
