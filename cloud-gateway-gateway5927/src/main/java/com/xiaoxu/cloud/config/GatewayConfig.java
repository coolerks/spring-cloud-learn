package com.xiaoxu.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Comparator;
import java.util.PriorityQueue;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator consumerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("baidu", f -> f.path("/baidu")
                        .uri("https://en.integer.top"))
                .build();
    }
}