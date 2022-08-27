package com.xiaoxu.cloud.consul.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class MyController {
    public static final String URL = "http://consul-provider-payment-8006/";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public Map<String, String> load() {
        return restTemplate.getForObject(URL + "payment/", HashMap.class);
    }
}
