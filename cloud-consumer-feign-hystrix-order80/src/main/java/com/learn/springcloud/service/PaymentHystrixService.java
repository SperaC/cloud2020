package com.learn.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {
    @GetMapping(value = "/payment/Hystrix/ok/{id}")
    String payment_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/Hystrix/timeout/{id}")
    String payment_TimeOut(@PathVariable("id")Integer id);
}
