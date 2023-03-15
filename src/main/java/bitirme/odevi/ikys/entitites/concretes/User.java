package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "kullanicilar", uniqueConstraints = {@UniqueConstraint(columnNames = {"e_posta"})})
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @NotNull
    @Column(name = "e_posta")
    @Email
    @NotBlank(message = "ePosta is mandatory")
    private String ePosta;

    @NotNull
    @Column(name = "sifre")
    @NotBlank(message = "sifre is mandatory")
    private String sifre;

    @NotNull
    @Column(name = "sifre_tekrari")
    @NotBlank(message = "sifreTekrari is mandatory")
    private String sifreTekrari;


    @Column(name = "aktif_mi")
    private boolean aktifMi = false;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Resim resim;




}
