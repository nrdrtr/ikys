package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private int id;

    @NotNull
    @Column(name = "email")
    @NotBlank(message = "ePosta is mandatory")
    private String email;


    @Column(name = "user_type")
    private String userType;

    @NotNull
    @Column(name = "password")
    @NotBlank(message = "sifre is mandatory")
    private String password;

    @Column(name = "is_verified", columnDefinition = "boolean default false")
    private boolean isVerified;

    @NotNull
    @Column(name = "password_again")
    @NotBlank(message = "passwordAgain is mandatory")
    private String passwordAgain;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Image image;

}
