package com.xiaoxu.cloud.controller;

import com.xiaoxu.api.bean.Payment;
import com.xiaoxu.api.bean.Result;
import com.xiaoxu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService service;

    @PostMapping("/")
    public Result<Integer> insert(@RequestBody Payment payment) {
        int result = service.insertPayment(payment);
        log.info("插入数据：{}, 结果：{}", payment, result);
        if (result > 0) {
            return new Result<>(200, "添加成功", result);
        }
        return new Result<>(400, "添加失败");

    }

    @GetMapping("/")
    public Result<List<Payment>> getAllPayments() {
        return new Result<>(400, "获取成功", service.getAllPayments());
    }

    @GetMapping("/{id}")
    public Result<Payment> getPaymentById(@PathVariable Integer id) {
        Payment payment = service.queryPaymentById(id);
        if (payment == null) {
            return new Result<>(400, "不存在");
        }
        return new Result<>(200, "获取成功", payment);
    }

    @DeleteMapping("/")
    public Result<Integer> deletePaymentById(@RequestBody Payment payment) {
        int i = service.deletePayment(payment);
        if (i > 0) {
            return new Result<>(200, "删除成功", i);
        }
        return new Result<>(400, "删除失败");
    }

    public PaymentController(PaymentService service) {
        this.service = service;
    }
}
