package com.xiaoxu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
@Slf4j
public class MyController {
    @GetMapping("/normal")
    public String routine() {
        log.info("访问正常的方法");
        return "正常方法";
    }

    @GetMapping("/abnormal/{time}")
    public String abnormal(@PathVariable Integer time) throws InterruptedException {
        log.info("访问不正常的方法，时间延迟为：{}秒", time);
        Thread.sleep(time * 1000);
        return "延迟" + time + "秒";
    }
}
