package com.example.springbootoopproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootOopProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOopProjectApplication.class, args);
    }
}