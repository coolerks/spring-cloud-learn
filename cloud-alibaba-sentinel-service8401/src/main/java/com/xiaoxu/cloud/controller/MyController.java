package com.xiaoxu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
@Slf4j
public class MyController {
    @GetMapping("sentinel")
    public String health() {
        log.info("health方法，请求已进入");
        return "good";
    }

    @GetMapping("sentinel2")
    public String health2() {
        log.info("health2方法，请求已进入");
        return "good";
    }

    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable Integer time) throws InterruptedException {
        log.info("sleep方法，请求已进入");
        Thread.sleep(time * 1000);
        return "休眠" + time + "秒";
    }
}
