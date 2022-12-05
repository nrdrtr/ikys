package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favoriler")
public class Favori {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @NotNull
        private int id;

        @ManyToOne(cascade = CascadeType.DETACH)
        @JoinColumn(name = "is_arayan_id")
        private IsArayan isArayan;

        @ManyToOne(cascade = CascadeType.DETACH)
        @JoinColumn(name = "is_ilan_id")
        private  IsIlani isIlani;
}