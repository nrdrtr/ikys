package bitirme.odevi.ikys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class IkysApplication {

    private static final Logger logger = LoggerFactory.getLogger(IkysApplication.class);

    public static void main(String[] args) {

        logger.info("Application started!");
        SpringApplication.run(IkysApplication.class, args);


    }


}
