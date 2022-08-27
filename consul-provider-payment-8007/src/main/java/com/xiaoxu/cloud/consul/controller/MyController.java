package com.xiaoxu.cloud.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class MyController {
    @GetMapping("/")
    public Map<String, String> getPayment() {
        return new HashMap<>(){
            {
                put("info-8007", UUID.randomUUID().toString());
                put("name-8007", UUID.randomUUID().toString());
                put("size-8007", UUID.randomUUID().toString());
            }
        };
    }
}
