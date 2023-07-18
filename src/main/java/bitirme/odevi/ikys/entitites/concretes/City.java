package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class City {
     @Id
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