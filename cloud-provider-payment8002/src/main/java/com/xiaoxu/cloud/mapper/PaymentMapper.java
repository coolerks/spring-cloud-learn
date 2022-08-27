package com.xiaoxu.cloud.mapper;


import com.xiaoxu.api.bean.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    int insertPayment(Payment payment);

    List<Payment> queryAllPayments();

    Payment queryPaymentById(Integer id);

    int deletePaymentById(Payment payment);
}
