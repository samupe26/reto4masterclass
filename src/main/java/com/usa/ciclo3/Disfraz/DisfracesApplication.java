package com.usa.ciclo3.Disfraz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@SpringBootApplication

//@SpringBootApplication(scanBasePackages = {"controller", "repository", "repository.crudrepository", "service"})
//@EntityScan("entities")
//@EnableJpaRepositories("repository")

@SpringBootApplication(scanBasePackages = {"com.usa.ciclo3.controller", "com.usa.ciclo3.entities", "com.usa.ciclo3.repository", "com.usa.ciclo3.repository.crudrepository", "com.usa.ciclo3.service"})
@EntityScan("com.usa.ciclo3.entities")
@EnableJpaRepositories("com.usa.ciclo3.repository")


public class DisfracesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisfracesApplication.class, args);
	}

}
