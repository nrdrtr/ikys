package bitirme.odevi.ikys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class IkysApplication {

    private static final Logger logger = LoggerFactory.getLogger(IkysApplication.class);


    public static void main(String[] args) throws IOException {
        logger.info("Application started!");

        SpringApplication.run(IkysApplication.class, args);


    }


}
