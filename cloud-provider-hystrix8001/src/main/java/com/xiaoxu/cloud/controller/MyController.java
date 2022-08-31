package com.xiaoxu.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/hystrix")
@Slf4j
@DefaultProperties(defaultFallback = "defaultHandlerMethod")
public class MyController {
    @HystrixCommand
    @GetMapping("/normal")
    public String routine() {
        log.info("访问正常的方法");
        if (new Random().nextInt(100) % 2 == 0) {
            log.info("尝试抛出异常");
            throw new RuntimeException();
        }
        return "正常方法";
    }

    @GetMapping("/abnormal/{time}")
    @HystrixCommand(fallbackMethod = "handlerMethod", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "3000")
    })
    public String abnormal(@PathVariable Integer time) throws InterruptedException {
        log.info("访问不正常的方法，时间延迟为：{}秒", time);
        Thread.sleep(time * 1000);
        log.info("执行完成");
        return "延迟" + time + "秒";
    }

    @GetMapping("/break/{num}")
    @HystrixCommand(fallbackMethod = "breakHandler", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"), // 开启服务熔断
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"), // 请求次数
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "10000"), // 窗口期
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "60"), // 失败的百分比
    })
    public String serviceBreak(@PathVariable Integer num) {
        if (num < 0) {
            throw new RuntimeException();
        }
        return "已收到/hystrix/break/" + num + " 的请求";
    }

    public String breakHandler(Integer num) {
        return "已被服务降级，num = " + num;
    }

    public String handlerMethod(Integer time) {
        return "出错了，你设置的超时时间是" + time + "秒:(";
    }

    public String defaultHandlerMethod() {
        return "这是默认的处理错误的兜底方法";
    }

}
