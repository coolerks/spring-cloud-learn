package com.xiaoxu.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProvider {
    @Autowired
    private StreamBridge streamBridge;

    public boolean sendMessage(String message) {
        return streamBridge.send("cloud-in-0", MessageBuilder.withPayload(message).build());
    }
}
