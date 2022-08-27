package com.xiaoxu.cloud.controller;

import com.xiaoxu.api.bean.Payment;
import com.xiaoxu.api.bean.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    // 必须带有http等协议，结尾必须有/，修改为服务名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment/";
    private RestTemplate template;

    @PostMapping("/payment")
    public Result<Payment> insert(@RequestBody Payment payment) {
        return template.postForObject(PAYMENT_URL, payment, Result.class);
    }

    @GetMapping("/payment")
    public Result<List<Payment>> getAllPayment() {
        return template.getForObject(PAYMENT_URL, Result.class);
    }

    public OrderController(RestTemplate template) {
        this.template = template;
    }
}
