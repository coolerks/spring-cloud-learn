package com.xiaoxu.cloud.feign.controller;

import com.xiaoxu.api.bean.Payment;
import com.xiaoxu.api.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class MyController {
    @Autowired
    private MyFeign myFeign;

    @GetMapping("/")
    public Result<List<Payment>> getAllPayments() {

        return myFeign.getAllPayments();
    }

    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable Integer time) {
        return myFeign.timeout(time);
    }

}
