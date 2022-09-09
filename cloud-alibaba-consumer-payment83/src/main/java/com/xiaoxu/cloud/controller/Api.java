package com.xiaoxu.cloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("cloud-alibaba-provider-payment")
public interface Api {
    @GetMapping("/my/nacos")
    String useApi();
}
