package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","user"})
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
