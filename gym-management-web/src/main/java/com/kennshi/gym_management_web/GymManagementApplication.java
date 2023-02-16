package com.kennshi.gym_management_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.kennshi.gym_management_rest", "com.kennshi.gym_management_web"})
@EntityScan(basePackages = {"com.kennshi.gym_management_rest"})
@SpringBootApplication
public class GymManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymManagementApplication.class, args);
	}
}
