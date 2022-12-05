package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "job_positions", uniqueConstraints = {@UniqueConstraint(columnNames = {"job_title"})})
@AllArgsConstructor
@NoArgsConstructor
public class IsPozisyonu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "job_title")
    @NotNull
    private String jobTitle;

    @JsonIgnore
    @OneToMany(mappedBy = "isPozisyonu")
    private List< IsIlani> isIlani;
}
