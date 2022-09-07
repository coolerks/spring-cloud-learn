package client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class MyController {
    @Value("${name.message}")
    private String message;

    @RequestMapping("/message")
    public String getMessage() {
        return message;
    }
}
