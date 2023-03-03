package bitirme.odevi.ikys.core.utilities.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);//super anahtar kelimesi ile RuntimeException sınıfının constructor'ına mesajımızı gönderiyoruz.
    }
}
