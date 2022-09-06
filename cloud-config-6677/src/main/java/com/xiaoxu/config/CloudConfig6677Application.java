package com.xiaoxu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfig6677Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfig6677Application.class, args);
	}

}
