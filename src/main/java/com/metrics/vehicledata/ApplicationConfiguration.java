package com.metrics.vehicledata;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
