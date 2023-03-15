package bitirme.odevi.ikys.core.services;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;


public interface CloudStorageService {

    DataResult<?> upload(MultipartFile multipartFile);

    DataResult<?> delete(String publicIdOfImage);

}