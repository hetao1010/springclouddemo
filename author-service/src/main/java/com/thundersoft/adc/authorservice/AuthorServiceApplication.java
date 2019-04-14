package com.thundersoft.adc.authorservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.thundersoft.adc.authorservice.person.dao")
@EnableEurekaClient
public class AuthorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorServiceApplication.class, args);
    }

}
