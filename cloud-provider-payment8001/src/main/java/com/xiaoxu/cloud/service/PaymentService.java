package com.xiaoxu.cloud.service;

import com.xiaoxu.api.bean.Payment;
import com.xiaoxu.cloud.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private PaymentMapper mapper;

    public int insertPayment(Payment payment) {
        return mapper.insertPayment(payment);
    }

    public List<Payment> getAllPayments() {
        return mapper.queryAllPayments();
    }

    public Payment queryPaymentById(Integer id) {
        return mapper.queryPaymentById(id);
    }

    public int deletePayment(Payment payment) {
        return mapper.deletePaymentById(payment);
    }

    public PaymentService(PaymentMapper mapper) {
        this.mapper = mapper;
    }
}
