package bitirme.odevi.ikys.core.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
 @Entity
@Table(name = "")
public class User {

        @Id
        private int id;

}
