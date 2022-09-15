package com.xiaoxu.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandler {
    public static String itemHandler(Integer index, BlockException exception) {
        return "获取" + index + "处的值失败-服务器2";
    }
}
