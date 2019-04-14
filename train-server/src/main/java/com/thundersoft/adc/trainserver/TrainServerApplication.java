package com.thundersoft.adc.trainserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@ComponentScan("com.thundersoft.adc")
public class TrainServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainServerApplication.class, args);
    }

}
