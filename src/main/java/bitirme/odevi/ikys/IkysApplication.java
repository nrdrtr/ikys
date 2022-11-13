package bitirme.odevi.ikys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


 

@EnableWebMvc
@Component
@Configuration
@SpringBootApplication
public class IkysApplication {

	public static void main(String[] args) {
		SpringApplication.run(IkysApplication.class, args);
	}
//	@Bean
//	public Docket  api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("bitirme.odevi.ikys"))
//				.build();
//	}
}
