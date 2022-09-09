package com.xiaoxu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class MyController {
    @Value("${config.info}")
    private String config;

    @GetMapping("/info")
    public String getConfigInfo() {
        return config;
    }
}
