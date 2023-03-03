package bitirme.odevi.ikys.core.services;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {
    DataResult<Map> addPicture(MultipartFile file) throws IOException;
}
