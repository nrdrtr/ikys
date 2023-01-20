package bitirme.odevi.ikys;

import com.cloudinary.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.cloudinary.*;
import java.io.IOException;



//@EnableWebMvc
//@Component
//@Configuration
// @EnableScheduling
@SpringBootApplication

public class IkysApplication {

	private static final Logger logger = LoggerFactory.getLogger(IkysApplication.class);

	public static void main(String[] args) throws IOException {
		logger.info("Application started!");


		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dztwwdpj9",
				"api_key", "719749748194426",
				"api_secret", "tR_1Fxv8wN9_wfGIkYUE4XOZMuY"));
//		SingletonManager manager = new SingletonManager();
//		manager.setCloudinary(cloudinary);
//		manager.init();

		SpringApplication.run(IkysApplication.class, args);


	}



}
