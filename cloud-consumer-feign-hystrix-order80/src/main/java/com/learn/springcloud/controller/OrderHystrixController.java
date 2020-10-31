package com.learn.springcloud.controller;

import com.learn.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    PaymentHystrixService paymentHystrixService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consumer/payment/Hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id")Integer id){
        String result=paymentHystrixService.payment_OK(id);
        return result;
    }
    @GetMapping(value = "/consumer/payment/Hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id")Integer id){
        String result=paymentHystrixService.payment_TimeOut(id);
        return result;
    }
}
