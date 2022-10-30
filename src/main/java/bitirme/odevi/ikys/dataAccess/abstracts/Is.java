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
@Table(name = "is")
@Getter
@Setter
public class Is {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "is_id")
    private int is_id;


    @Column(name = "is_adi")
    private String is_adi;

    @OneToMany(mappedBy = "is")
    private List<IsPozisyonlari>  isPozisyonlari;

}
