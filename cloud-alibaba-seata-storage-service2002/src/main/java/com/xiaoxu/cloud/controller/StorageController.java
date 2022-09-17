package com.xiaoxu.cloud.controller;

import com.xiaoxu.cloud.bean.Storage;
import com.xiaoxu.cloud.mapper.StorageMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/storage")
@GlobalTransactional
public class StorageController {
    @Autowired
    StorageMapper mapper;

    @GetMapping("/")
    public List<Storage> getAllStorage() {
        return mapper.getAllStorage();
    }

    @GetMapping("/{id}")
    public Storage getStorage(@PathVariable Integer id) {
        return mapper.getStorageById(id);
    }

    @PostMapping("/")
    public Storage insert(@RequestBody Storage storage) {
        mapper.insert(storage);
        return storage;
    }

    @PutMapping("/{id}/{used}")
    public Storage update(@PathVariable Integer id, @PathVariable Integer used) {
        log.info("商品服务-xid = " + RootContext.getXID());
        Storage storage = getStorage(id);
        Integer used1 = storage.getUsed();
        mapper.update(id, used1 + used);
        return getStorage(id);
    }
}
