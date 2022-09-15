package com.xiaoxu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaoxu.cloud.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey", blockHandler = "hotKeyHandler")
    public String hotKey(@RequestParam(value = "content", required = false) String content, @RequestParam(value = "param", required = false) String param) {
        return "hotkey - content = " + content + ",  param = " + param;
    }

    public String hotKeyHandler(String content, String param, BlockException exception) {
        return "hotkey - content = " + content + ",  param = " + param + ":(";

    }


    @GetMapping("/resource")
    @SentinelResource(value = "resource", blockHandler = "resourceHandler")
    public Map<String, String> resource() {
        HashMap<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("status", "访问成功");
        return map;
    }

    @GetMapping("/first")
    @SentinelResource(value = "first", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "firstHandler")
    public Map<String, Object> first() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("status", "访问成功---first");
        return map;
    }

    @GetMapping("/second")
    @SentinelResource(value = "second", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "secondHandler")
    public Map<String, Object> second() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("status", "访问成功---second");
        return map;
    }

    public Map<String, String> resourceHandler(BlockException exception) {
        HashMap<String, String> map = new HashMap<>();
        map.put("code", "400");
        map.put("status", "访问失败");
        map.put("cause", exception.getMessage());
        return map;
    }
}
