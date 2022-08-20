package com.rafaelbandim.genericapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class GenericAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenericAppApplication.class, args);
    }

}
