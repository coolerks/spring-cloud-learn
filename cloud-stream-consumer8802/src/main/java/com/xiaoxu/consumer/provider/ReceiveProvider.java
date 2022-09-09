package com.xiaoxu.consumer.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class ReceiveProvider {

    @Bean
    public Consumer<String> cloud() {
        return message -> {
            log.info("接收消息为：{}", message);
        };
    }
}
