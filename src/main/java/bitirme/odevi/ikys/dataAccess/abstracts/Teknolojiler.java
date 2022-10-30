package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teknolojiler")
@Getter
@Setter
public class Teknolojiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne()
    @JoinColumn(name = "ozgecmis_id",referencedColumnName = "id")
    private Ozgecmisler ozgecmisler;


    @Column(name = "teknolojiler")
    private String teknolojiler;

}
