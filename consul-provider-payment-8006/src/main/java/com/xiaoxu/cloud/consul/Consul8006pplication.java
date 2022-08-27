package com.xiaoxu.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Consul8006pplication {
    public static void main(String[] args) {
        SpringApplication.run(Consul8006pplication.class, args);
    }
}
