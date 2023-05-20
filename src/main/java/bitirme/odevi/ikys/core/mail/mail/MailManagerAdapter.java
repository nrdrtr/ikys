package bitirme.odevi.ikys.core.mail.mail;

//import bitirme.odevi.ikys.mail.MailManager;

public class MailManagerAdapter implements MailService {

    @Override
    public void send(String message) {
      //  MailManager mailManager = new MailManager();
        System.out.println("Mail gönderildi: " + message);
    }
}

