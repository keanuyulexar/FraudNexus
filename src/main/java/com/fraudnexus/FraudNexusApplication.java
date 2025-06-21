package com.fraudnexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.fraudnexus.repository")
@EntityScan("com.fraudnexus.entity")

public class FraudNexusApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudNexusApplication.class, args);
    }

}
