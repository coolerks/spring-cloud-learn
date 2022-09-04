package com.xiaoxu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Stack;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class EurekaServer7001Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001Application.class, args);
    }
}
