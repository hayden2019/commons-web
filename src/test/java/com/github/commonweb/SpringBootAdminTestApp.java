package com.github.commonweb;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootAdminTestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminTestApp.class, args);
    }


}
