package bitirme.odevi.ikys.entitites.concretes;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "sosyal_medyalar")
@Setter

public class SosyalMedyalar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int sosyalMedyaId;

    @Column(name = "sosyal_medya_adi")
    String sosyalMedyaAdı;
}
