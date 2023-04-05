package com.kennshi.gym_management_web.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.kennshi.gym_management_rest.domain")
@EnableJpaRepositories(basePackages = "com.kennshi.gym_management_rest.repositories")
@ComponentScan(basePackages = {"com.kennshi.gym_management_web", "com.kennshi.gym_management_rest"})
@Configuration
public class SpringConfig {
}
