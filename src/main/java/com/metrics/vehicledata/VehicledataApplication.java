package com.metrics.vehicledata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VehicledataApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicledataApplication.class, args);
    }

}
