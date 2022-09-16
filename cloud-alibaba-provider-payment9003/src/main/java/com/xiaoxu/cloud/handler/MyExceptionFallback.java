package com.xiaoxu.cloud.handler;

public class MyExceptionFallback {
    public static String itemExceptionFallback(Integer index, Throwable e) {
        return "抛异常了，服务器1，index = " + index + ", 异常信息为：" + e;
    }
}
