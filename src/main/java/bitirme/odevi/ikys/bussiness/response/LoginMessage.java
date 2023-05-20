package bitirme.odevi.ikys.bussiness.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginMessage {

    String message;

    Boolean status;

}