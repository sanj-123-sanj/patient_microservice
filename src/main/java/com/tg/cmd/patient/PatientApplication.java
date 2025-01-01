package com.tg.cmd.patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication  // Marks this class as the entry point for the Spring Boot application
public class PatientApplication {

    public static void main(String[] args) {
        // Runs the Spring Boot application
        SpringApplication.run(PatientApplication.class, args);
    }

    // Bean definition for RestTemplate to facilitate REST API calls
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();  // Creates a new instance of RestTemplate
    }
}
