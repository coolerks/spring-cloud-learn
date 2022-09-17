package com.xiaoxu.cloud.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Order {
    Integer id, userId, productId, count, status;
    Double money;
}
