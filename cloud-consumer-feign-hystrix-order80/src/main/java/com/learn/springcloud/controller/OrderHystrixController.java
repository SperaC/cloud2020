package com.learn.springcloud.controller;

import com.learn.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_GlobalFallbackMethod")    //全局的
public class OrderHystrixController {
    @Resource
    PaymentHystrixService paymentHystrixService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consumer/payment/Hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id")Integer id){
        return paymentHystrixService.payment_OK(id);
    }
//   @HystrixCommand(fallbackMethod = "payment_TimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
//   })
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/Hystrix/timeout/{id}")
    public String payment_TimeOut(@PathVariable("id")Integer id){
        int age=10/0;
        return paymentHystrixService.payment_TimeOut(id);
    }
    public String payment_TimeOutFallbackMethod(Integer id){
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }
    //全局的fallback方法
    public String payment_GlobalFallbackMethod(){
        return "Global，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }
}
