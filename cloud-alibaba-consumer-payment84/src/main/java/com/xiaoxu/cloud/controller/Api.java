package com.xiaoxu.cloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("cloud-alibaba-payment")
@Component
public interface Api {
    @GetMapping("/payment/list")
    List<String> getList();

    @GetMapping("/payment/{index}")
    String getItem(@PathVariable("index") Integer index);
}
