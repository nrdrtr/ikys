package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "cities")
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
     private String cityName;

     @JsonIgnore
     @OneToMany(mappedBy = "sehir", cascade = CascadeType.DETACH)
     private List<IsIlani> isIlanlari;
}