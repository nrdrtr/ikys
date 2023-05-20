package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class City {
     @Id
     @NotNull
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     @Column(name = "city_name")
     @NotNull
     private String cityName;

     @JsonIgnore
     @OneToMany(mappedBy = "city", cascade = CascadeType.DETACH)
     private List<JobAdvertisement> jobAdvertisements;
}