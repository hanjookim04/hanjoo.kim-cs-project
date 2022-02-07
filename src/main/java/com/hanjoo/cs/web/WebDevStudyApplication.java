package com.hanjoo.cs.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebDevStudyApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebDevStudyApplication.class, args);
    }

}
