package kr.jellyms.custommapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"kr.jellyms.custommapper"})
public class CustommapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustommapperApplication.class, args);
    }

}
