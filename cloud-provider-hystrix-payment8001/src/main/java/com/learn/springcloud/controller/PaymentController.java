package com.learn.springcloud.controller;

import com.learn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/Hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*****"+result);
        return result;
    }
    @GetMapping(value = "/payment/Hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****"+result);
        return result;
    }

    //=====服务熔断
    @GetMapping(value = "/payment/circuit/{id}")
    public String payment_CircuitBreaker(@PathVariable("id")Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****"+result);
        return result;
    }
}
