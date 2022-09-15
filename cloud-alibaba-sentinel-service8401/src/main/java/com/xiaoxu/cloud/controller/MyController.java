package com.xiaoxu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
}
