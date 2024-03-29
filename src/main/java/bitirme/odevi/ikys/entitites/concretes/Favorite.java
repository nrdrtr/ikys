package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorites")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Favorite {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @NotNull
        private int id;

        @ManyToOne(cascade = CascadeType.DETACH)
        @JoinColumn(name = "job_seeker_id")
        private JobSeeker jobSeeker;

        @ManyToOne(cascade = CascadeType.DETACH)
        @JoinColumn(name = "job_advertisement_id")
        private JobAdvertisement jobAdvertisement;
}