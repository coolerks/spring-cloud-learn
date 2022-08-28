package com.xiaoxu.cloud.controller;

import com.xiaoxu.api.bean.Payment;
import com.xiaoxu.api.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
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

    @GetMapping("/payment2")
    public ResponseEntity<Result> getAllPayment2() {
        ResponseEntity<Result> forEntity = template.getForEntity(PAYMENT_URL, Result.class);
        HttpHeaders headers = forEntity.getHeaders();
        log.info("headers = {}", headers);
        log.info("body = {}", forEntity.getBody());
        log.info("code = {}", forEntity.getStatusCode());
        log.info("entity = {}", forEntity);
        log.info("是否响应4XX：{}", forEntity.getStatusCode().is4xxClientError());
        log.info("是否响应2XX：{}", forEntity.getStatusCode().is2xxSuccessful());
        return forEntity;
    }

    public OrderController(RestTemplate template) {
        this.template = template;
    }
}
