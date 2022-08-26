package com.xiaoxu.api.bean;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    Integer id;
    String serial;
}
