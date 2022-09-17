package com.xiaoxu.cloud.controller;

import com.xiaoxu.cloud.bean.User;
import com.xiaoxu.cloud.mapper.UserMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@GlobalTransactional
public class UserController {
    @Autowired
    private UserMapper mapper;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return mapper.getUserById(id);
    }

    @PutMapping("/{id}/{total}")
    public User update(@PathVariable Integer id, @PathVariable Double total) {
        log.info("用户服务-xid = " + RootContext.getXID());
        User user = mapper.getUserById(id);
        mapper.updateUser(id, user.getTotal() - total);
        return getUser(id);
    }
}
