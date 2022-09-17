package com.xiaoxu.cloud.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Storage {
    Integer id, total, used;
    Double price;
}
