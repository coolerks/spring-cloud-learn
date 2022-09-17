package com.xiaoxu.cloud;

import com.xiaoxu.cloud.bean.Order;
import com.xiaoxu.cloud.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeataOrder2001ApplicationTests {
    @Autowired
    OrderMapper mapper;
    @Test
    void contextLoads() {
        System.out.println("\n\n\n\n==========修改状态前===========");
        System.out.println("mapper.queryById(1) = " + mapper.queryById(1));
        mapper.updateStatus(1, 1);
        System.out.println("mapper.queryById(1) = " + mapper.queryById(1));
        System.out.println("==========修改状态后===========\n\n\n\n");

//        Order order = new Order();
//        order.setCount(1);
//        order.setStatus(0);
//        order.setMoney(100.0);
//        order.setProductId(1);
//        order.setUserId(1);
//
//        System.out.println("order插入前 = " + order);
//        mapper.insert(order);
//        System.out.println("order插入后 = " + order);
//
//        System.out.println("mapper.queryAllOrders() = " + mapper.queryAllOrders());
//        System.out.println("mapper.queryById(1) = " + mapper.queryById(1));
    }
}



