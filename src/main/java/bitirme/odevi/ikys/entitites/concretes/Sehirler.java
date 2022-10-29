package bitirme.odevi.ikys.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sehirler")
public class Sehirler {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "sehir_id")
     private int id;
     @Column(name = "sehir_adi")
     private String sehirIsmi;

     @OneToOne(mappedBy = "sehirler")
     private IsIlanlari isIlanlari;
}

