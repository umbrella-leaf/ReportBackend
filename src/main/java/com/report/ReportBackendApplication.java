package com.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReportBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportBackendApplication.class, args);
    }

}
