package com.xiaoxu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class MyController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Api api;

    public static final String URL = "http://cloud-alibaba-provider-payment";

    @GetMapping("/nacos")
    public String consumer() {
        return restTemplate.getForObject(URL + "/my/nacos", String.class);
    }

    @GetMapping("/feign/nacos")
    public String feign() {
        return api.useApi() + "feign";
    }
}
