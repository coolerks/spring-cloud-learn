package com.xiaoxu.cloud.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class MyController {
    @Autowired
    private Api api;

    @GetMapping("/list")
    public List<String> getList() {
        return api.getList();
    }

    @GetMapping("/{index}")
    public String getItem(@PathVariable Integer index) {
        return api.getItem(index) + "-客户端";
    }
}
