package bitirme.odevi.ikys.entitites.concretes;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "token", nullable = false, unique = true )
    public String confirmationToken;

    @Column(name = "creation_date", nullable = false)
    private Date createdDate;

    @Column(name = "expration_date", nullable = false)
    private Date expirationDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
}
