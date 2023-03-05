package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.ResimService;
import bitirme.odevi.ikys.dataAccess.abstracts.ResimDao;
import bitirme.odevi.ikys.entitites.concretes.Resim;
import com.cloudinary.Cloudinary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class ResimManager implements ResimService {

    private Cloudinary cloudinary;
    private ResimDao resimDao;

    @Override
    public Resim uploadImage(MultipartFile file) throws IOException {

        Map<String, String> options = new HashMap<>();
        options.put("public_id", file.getOriginalFilename());
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), options);

        Resim resim = new Resim();
        resim.setPublicId(uploadResult.get("public_id").toString());
        resim.setUrl(uploadResult.get("url").toString());

        resimDao.save(resim);

        return resim;
    }

}
