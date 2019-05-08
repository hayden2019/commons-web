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
@RestController
public class SpringBootAdminClientTestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClientTestApp.class, args);
    }
    @GetMapping("/hello")
    public ArrayList<String> hello(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("e");
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return strings;
    }

}
