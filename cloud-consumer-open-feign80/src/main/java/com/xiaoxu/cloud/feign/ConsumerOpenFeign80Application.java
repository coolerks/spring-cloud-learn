package com.xiaoxu.cloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerOpenFeign80Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeign80Application.class, args);
    }
}
