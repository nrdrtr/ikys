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
@Table(name = "teknolojiler")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ozgecmis"})

public class Teknoloji {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "technologies")
    private String plName;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ozgecmis_id")
    private Ozgecmis ozgecmis;
}
