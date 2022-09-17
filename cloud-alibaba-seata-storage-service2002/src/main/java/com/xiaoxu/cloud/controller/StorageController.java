package com.xiaoxu.cloud.controller;

import com.xiaoxu.cloud.bean.Storage;
import com.xiaoxu.cloud.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
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
        Storage storage = getStorage(id);
        Integer used1 = storage.getUsed();
        mapper.update(id, used1 + used);
        return getStorage(id);
    }
}
