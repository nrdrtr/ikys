package bitirme.odevi.ikys.core.services;


import bitirme.odevi.ikys.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryUploaderManagerAdapter implements CloudinaryService {

    private final CloudinaryManager cloudinaryManager;

    @Autowired
    public CloudinaryUploaderManagerAdapter(CloudinaryManager cloudinaryManager) {
        this.cloudinaryManager = cloudinaryManager;
    }

    @Override
    public DataResult<Map> addPicture(MultipartFile file) throws IOException {
        return null;
    }

}