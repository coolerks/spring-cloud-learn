package com.xiaoxu.producer.controller;

import com.xiaoxu.producer.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MyController {
    @Autowired
    private MessageProvider messageProvider;

    @GetMapping("/send/{msg}")
    public boolean send(@PathVariable String msg) {
        return messageProvider.sendMessage(msg);
    }
}
