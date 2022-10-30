package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "favoriler")
@Getter
@Setter
public class Favoriler {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        @ManyToOne()
        @JoinColumn(name = "is_arayan_id",referencedColumnName = "kullanıcı_id")
        private IsArayanlar isArayanlar;

        @ManyToOne(cascade = CascadeType.DETACH)
        @JoinColumn(name = "is_ılan_id")
        private IsIlanlari isIlanlari;


}
