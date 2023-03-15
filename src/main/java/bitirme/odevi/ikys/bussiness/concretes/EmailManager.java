package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import bitirme.odevi.ikys.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

@Service
public class EmailManager {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private EmailService emailService;

    public void sendVerificationEmail(IsArayan isArayan) throws MessagingException, FileNotFoundException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(isArayan.getEPosta());
        message.setSubject("Doğrulama Bağlantısı");
        emailService.sendEmailWithAttachment("classpath:MailDogrulamaSayfasi.html", "Doğrulama Bağlantısı", "", "");
        emailSender.send(message);
    }



}
