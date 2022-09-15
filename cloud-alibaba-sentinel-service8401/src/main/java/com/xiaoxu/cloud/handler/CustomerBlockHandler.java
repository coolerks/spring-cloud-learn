package com.xiaoxu.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import java.util.HashMap;
import java.util.Map;

public class CustomerBlockHandler {
    public static Map<String, Object> firstHandler(BlockException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "400");
        map.put("cause", e);
        map.put("message", "失败---first");
        return map;
    }

    public static Map<String, Object> secondHandler(BlockException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "400");
        map.put("cause", e);
        map.put("message", "失败---second");
        return map;
    }
}
