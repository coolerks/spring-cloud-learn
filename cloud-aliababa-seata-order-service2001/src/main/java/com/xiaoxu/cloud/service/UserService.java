package com.xiaoxu.cloud.service;

import com.xiaoxu.cloud.bean.Storage;
import com.xiaoxu.cloud.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient("cloud-alibaba-seata-user-service")
public interface UserService {
    @PutMapping("/user/{id}/{total}")
    User update(@PathVariable("id") Integer id, @PathVariable("total") Double total);

    @GetMapping("/user/{id}")
    Storage getUser(@PathVariable("id") Integer id);
}
