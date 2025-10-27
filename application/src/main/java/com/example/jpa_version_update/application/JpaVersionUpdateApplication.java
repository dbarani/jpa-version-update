package com.example.jpa_version_update.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableJpaRepositories(basePackages = "com.example.jpa_version_update.jpa.repository")
@EntityScan(basePackages = "com.example.jpa_version_update.jpa")
public class JpaVersionUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaVersionUpdateApplication.class, args);
	}

}
