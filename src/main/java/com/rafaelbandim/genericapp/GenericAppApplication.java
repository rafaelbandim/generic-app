package com.rafaelbandim.genericapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(excludeName = {
        "org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration",
        "org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration"
})
public class GenericAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenericAppApplication.class, args);
    }

}
