package com.fushi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.fushi.service",
                "com.fushi.serviceImpl",
                "com.fushi.exception",
                "com.fushi.controller",
                "com.fushi.util",
                "com.fushi.config",
                "com.fushi.security"})
@EnableJpaRepositories(basePackages = {"com.fushi.repository"})
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
