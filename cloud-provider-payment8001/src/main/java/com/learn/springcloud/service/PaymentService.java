package com.learn.springcloud.service;

import com.learn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int i=0;
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
