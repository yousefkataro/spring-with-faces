package io.aturanj.sales;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = {"io.aturanj.sales", "io.aturanj.sales.service"})
public class PrimefaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrimefaceApplication.class, args);
        log.info(".................YNK.......................Application has been launched");
    }

}
