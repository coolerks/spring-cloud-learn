package com.xiaoxu.cloud.mapper;

import com.xiaoxu.cloud.bean.Storage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StorageMapper {
    @Insert("insert into storages(price, total, used) values (#{price}, #{total}, #{used})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insert(Storage storage);

    @Select("select id, price, total, used from storages")
    List<Storage> getAllStorage();

    @Select("select id, price, total, used from storages where id = #{id}")
    Storage getStorageById(Integer id);

    @Update("update storages set used = #{used} where id = #{id}")
    int update(@Param("id") Integer id, @Param("used") Integer used);
}
