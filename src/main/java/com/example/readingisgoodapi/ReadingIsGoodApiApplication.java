package com.example.readingisgoodapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class ReadingIsGoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingIsGoodApiApplication.class, args);
    }

}
