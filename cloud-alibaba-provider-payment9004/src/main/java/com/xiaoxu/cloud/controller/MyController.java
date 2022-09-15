package com.xiaoxu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xiaoxu.cloud.handler.MyBlockHandler;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RefreshScope
@ConfigurationProperties(prefix = "")
@Data
public class MyController {
    List<String> list;

    @GetMapping("/list")
    public List<String> getList() {
        return list;
    }

    @GetMapping("/{index}")
    @SentinelResource(value = "index", blockHandlerClass = MyBlockHandler.class, blockHandler = "itemHandler")
    public String getItem(@PathVariable Integer index) {
        return list.get(index) + " - 服务器2";
    }
}
