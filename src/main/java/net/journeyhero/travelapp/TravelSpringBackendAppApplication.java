package net.journeyhero.travelapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TravelSpringBackendAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelSpringBackendAppApplication.class, args);
    }

}
