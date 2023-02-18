package com.kennshi.gym_management_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.kennshi.gym_management_rest.domain")
@EnableJpaRepositories(basePackages = "com.kennshi.gym_management_rest.repositories")
@SpringBootApplication(scanBasePackages = { "com.kennshi.gym_management_web", "com.kennshi.gym_management_rest"})
public class GymManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymManagementApplication.class, args);
	}
}
