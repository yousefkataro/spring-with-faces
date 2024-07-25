package io.aturanj.sales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"io.aturanj.sales", "io.aturanj.sales.service"})
public class PrimefaceApplication {

    private final static Logger logger = LoggerFactory
            .getLogger(PrimefaceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PrimefaceApplication.class, args);
        logger.info(".................YNK.......................Application has been launched");
    }

}
