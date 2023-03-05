package com.example.normal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class NormalApplication {

    public static void main(String[] args) {
        SpringApplication.run(NormalApplication.class, args);
    }

}
