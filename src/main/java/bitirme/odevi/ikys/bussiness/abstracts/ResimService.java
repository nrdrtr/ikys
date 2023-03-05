package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.entitites.concretes.Resim;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ResimService {
    Resim uploadImage(MultipartFile file) throws IOException;
}
