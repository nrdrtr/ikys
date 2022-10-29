package bitirme.odevi.ikys.entitites.concretes;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kullanıcılar")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Kullanıcılar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kullanıcı_id",nullable = false )
    @NotNull
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "şifre")
    private String sifre;
}
