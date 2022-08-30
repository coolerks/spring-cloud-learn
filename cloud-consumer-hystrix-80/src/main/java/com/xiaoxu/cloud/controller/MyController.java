package com.xiaoxu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class MyController {
    @Autowired
    private Api api;

    @GetMapping("/normal")
    public String normal() {
        return api.normal() + " - consumer";
    }

    @GetMapping("/abnormal/{time}")
    public String abnormal(@PathVariable Integer time) {
        return api.abnormal(time) + " - consumer";
    }
}
