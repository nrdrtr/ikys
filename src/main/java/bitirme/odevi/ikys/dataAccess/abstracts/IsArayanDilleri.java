package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "is_arayan_dilleri")
@Getter
@Setter
public class IsArayanDilleri {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int  id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "language_id")
    private Diller diller;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ozgecmis_id",referencedColumnName = "id")
    private Ozgecmisler ozgecmisler;




}
