package com.xiaoxu.eureka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/get")
@Slf4j
public class StatusController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String ip(HttpServletRequest request) {
        log.info("info = {}", request.getRemoteHost());
        return "访问成功";
    }

    @GetMapping("/service")
    public List<String> getDiscoveryService() {
        discoveryClient.getServices().forEach(it -> {
            log.info("************{}", it);
        });
        return discoveryClient.getServices();
    }

    @GetMapping("/service/{name}")
    public List<ServiceInstance> getInstance(@PathVariable String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances(name);
        log.info("instance = {} ", instances);
        return instances;
    }
}
