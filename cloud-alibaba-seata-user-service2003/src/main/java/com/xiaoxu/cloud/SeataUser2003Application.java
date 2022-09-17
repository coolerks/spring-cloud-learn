package com.xiaoxu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeataUser2003Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataUser2003Application.class, args);
    }
}
