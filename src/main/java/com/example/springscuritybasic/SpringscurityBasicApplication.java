package com.example.springscuritybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringscurityBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringscurityBasicApplication.class, args);
    }

}
