package com.xiaoxu.cloud.controller;

import com.xiaoxu.cloud.bean.Order;
import com.xiaoxu.cloud.bean.Storage;
import com.xiaoxu.cloud.mapper.OrderMapper;
import com.xiaoxu.cloud.service.StorageService;
import com.xiaoxu.cloud.service.UserService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@GlobalTransactional
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    OrderMapper mapper;

    @Autowired
    UserService userService;

    @Autowired
    StorageService storageService;

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return mapper.queryAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Integer id) {
        return mapper.queryById(id);
    }

    @PostMapping("/")
    public Order insert(@RequestBody Order order) {
        log.info("订单服务-xid = " + RootContext.getXID());
        mapper.insert(order);
        log.info("=========开始下订单========");
        log.info("订单信息：{}", getOrder(order.getId()));
        log.info("减少库存前的商品状态：{}", storageService.getStorage(order.getProductId()));
        log.info("=========开始减少库存========");
        Storage storage = storageService.update(order.getProductId(), order.getCount());
        log.info("减库存后：{}", storage);
        log.info("扣除余额前的用户状态：{}", userService.getUser(order.getUserId()));
        log.info("=========开始减少余额========");
        if (order.getCount() == 2) {
            throw new RuntimeException();
        }
        log.info("减少余额后：{}", userService.update(order.getUserId(), order.getCount() * storage.getPrice()));
        log.info("改变订单状态前：{}", getOrder(order.getId()));
        log.info("=========开始更改状态========");
        log.info("更改状态后：{}", updateStatus(order.getId(), 1));
        return getOrder(order.getId());
    }

    @PutMapping("/{id}/{status}")
    public Order updateStatus(@PathVariable Integer id, @PathVariable Integer status) {
        mapper.updateStatus(id, status);
        return getOrder(id);
    }

}
