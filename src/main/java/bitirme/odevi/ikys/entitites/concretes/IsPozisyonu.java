package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "is_pozisyonlari", uniqueConstraints = {@UniqueConstraint(columnNames = {"is_ismi"})})
@AllArgsConstructor
@NoArgsConstructor
public class IsPozisyonu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "is_ismi")
    @NotNull
    private String isIsmi;

    @JsonIgnore
    @OneToMany(mappedBy = "isPozisyonu",cascade=CascadeType.ALL)
    private List<IsIlani> isIlani;
}
