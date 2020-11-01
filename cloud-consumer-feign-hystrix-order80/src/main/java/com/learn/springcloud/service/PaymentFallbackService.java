package com.learn.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String payment_OK(Integer id) {
        return "------PaymentFallbackService fallback payment_OK o(╥﹏╥)o";
    }

    @Override
    public String payment_TimeOut(Integer id) {
        return "------PaymentFallbackService fallback payment_TimeOut o(╥﹏╥)o";
    }
}
