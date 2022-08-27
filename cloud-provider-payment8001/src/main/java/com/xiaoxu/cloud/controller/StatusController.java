package com.xiaoxu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
@Slf4j
public class StatusController {
    @Autowired
    DiscoveryClient discoveryClient;

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