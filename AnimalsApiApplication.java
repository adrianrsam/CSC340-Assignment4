package com.adrian.animalsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.adrian.animalsapi.demo") // Ensure this line is added
public class AnimalsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimalsApiApplication.class, args);
    }
}
