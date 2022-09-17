package com.xiaoxu.cloud.mapper;

import com.xiaoxu.cloud.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select id, total from user where id = 1")
    User getUserById(Integer id);

    @Update("update user set total = #{total} where id = #{id}")
    int updateUser(@Param("id") Integer id, @Param("total") Double total);
}
