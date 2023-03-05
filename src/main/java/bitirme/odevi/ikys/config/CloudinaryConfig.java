package bitirme.odevi.ikys.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dztwwdpj9",
                "api_key", "719749748194426",
                "api_secret", "tR_1Fxv8wN9_wfGIkYUE4XOZMuY"));
    }
}
