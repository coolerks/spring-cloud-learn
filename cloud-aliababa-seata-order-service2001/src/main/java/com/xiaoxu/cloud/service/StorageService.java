package com.xiaoxu.cloud.service;

import com.xiaoxu.cloud.bean.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient("cloud-alibaba-seata-storage-service")
public interface StorageService {

    @GetMapping("/storage/{id}")
    Storage getStorage(@PathVariable("id") Integer id);

    @PutMapping("/storage/{id}/{used}")
    Storage update(@PathVariable("id") Integer id, @PathVariable("used") Integer used);
}
