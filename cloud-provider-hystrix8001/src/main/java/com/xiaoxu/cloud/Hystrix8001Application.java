package com.xiaoxu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Hystrix8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001Application.class, args);
    }
}
