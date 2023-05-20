package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(force = true)
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","userType"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @NotNull
    @Column(name = "email")
    @NotBlank(message = "ePosta is mandatory")
    private String email;

    @NotNull
    @Column(name = "password")
    @NotBlank(message = "sifre is mandatory")
    private String password;

    @NotNull
    @Column(name = "password_again")
    @NotBlank(message = "passwordAgain is mandatory")
    private String passwordAgain;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Image image;

}
