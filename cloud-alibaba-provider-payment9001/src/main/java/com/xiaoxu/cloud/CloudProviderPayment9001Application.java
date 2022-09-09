package com.xiaoxu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment9001Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment9001Application.class, args);
    }
}
