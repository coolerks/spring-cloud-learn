package com.xiaoxu.cloud.feign.controller;

import com.xiaoxu.api.bean.Payment;
import com.xiaoxu.api.bean.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface MyFeign {
    @GetMapping("/payment/")
    Result<List<Payment>> getAllPayments();

    @GetMapping("/payment/timeout/{time}")
    String timeout(@PathVariable("time") Integer time);
}
