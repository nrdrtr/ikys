package bitirme.odevi.ikys.core.services;


import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;


@Service
public class CloudinaryManager {

    private Cloudinary cloudinary;


    public CloudinaryManager() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dztwwdpj9",
                "api_key", "719749748194426",
                "api_secret", "tR_1Fxv8wN9_wfGIkYUE4XOZMuY"));
    }
}
