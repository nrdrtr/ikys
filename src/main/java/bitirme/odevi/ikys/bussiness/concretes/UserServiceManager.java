package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.UserService;
import bitirme.odevi.ikys.core.services.EmailService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.ConfirmationTokenDao;
import bitirme.odevi.ikys.dataAccess.abstracts.UserDao;
import bitirme.odevi.ikys.entitites.concretes.ConfirmationToken;
import bitirme.odevi.ikys.entitites.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceManager implements UserService {


    private UserDao userDao;

    private ConfirmationTokenDao confirmationTokenDao;

    private EmailService emailService;

    @Override
    public DataResult<List<User>> getAll() {
        return null;
    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<>(this.userDao.getById(id));
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return null;
    }

    @Override
    public ResponseEntity<?> saveUser(User user) {

        if (userDao.existsByePosta(user.getEPosta())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        userDao.save(user);

        ConfirmationToken confirmationToken = new ConfirmationToken();

        confirmationTokenDao.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEPosta());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8085/confirm-account?token=" + confirmationToken.getConfirmationToken());
        emailService.sendEmail(mailMessage);

        System.out.println("Confirmation Token: " + confirmationToken.getConfirmationToken());

        return ResponseEntity.ok("Verify email by the link sent on your email address");
    }

    @Override
    public ResponseEntity<?> confirmEmail(String confirmationToken) {
        ConfirmationToken token = confirmationTokenDao.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = new User();
            user.setAktifMi(true);
            userDao.save(user);
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
    }
}