package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favoriler")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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