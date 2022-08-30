package com.xiaoxu.cloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("CLOUD-PROVIDER-HYSTRIX8001")
public interface Api {
    @GetMapping("/hystrix/normal")
    String normal();

    @GetMapping("/hystrix/abnormal/{time}")
    String abnormal(@PathVariable("time") Integer time);
}
