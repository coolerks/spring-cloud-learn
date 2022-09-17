package com.xiaoxu.cloud.mapper;

import com.xiaoxu.cloud.bean.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("insert into orders(userId, productId, count, money, status) values (#{userId}, #{productId}, #{count}, #{money}, #{status})")
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    int insert(Order order);

    @Update("update orders set status = #{status} where id = #{id}")
    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    @Select("select id, userId, productId, count, money, status from orders")
    List<Order> queryAllOrders();

    @Select("select id, userId, productId, count, money, status from orders where id = #{id}")
    Order queryById(Integer id);
}
