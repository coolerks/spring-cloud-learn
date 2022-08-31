package com.xiaoxu.cloud.controller;

import org.springframework.stereotype.Component;

@Component
public class ApiHandler implements Api{
    @Override
    public String normal() {
        return "服务端的normal出现异常了-来自客户端的提示";
    }

    @Override
    public String abnormal(Integer time) {
        return "服务端的abnormal出问题了-来自客户端的提示";
    }
}
