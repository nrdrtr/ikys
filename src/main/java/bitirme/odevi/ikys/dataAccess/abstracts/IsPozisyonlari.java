package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "is_pozisyonları")
@Getter
@Setter
public class IsPozisyonlari {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_ismi")
    private String isIsmi;


    @ManyToOne
    @JoinColumn(name = "is_id")
    private Is is;


    @OneToOne
    private IsIlanlari isIlanlari;
}
