package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Entity
@Table(name = "sehirler")
@AllArgsConstructor
@NoArgsConstructor
public class Sehir {
     @Id
     @NotNull
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     @Column(name = "sehir_adi")
     @NotNull
     private String sehirAdi;

     @JsonIgnore
     @OneToMany(mappedBy = "sehir", cascade = CascadeType.DETACH)
     private List<IsIlani> isIlanlari;
}