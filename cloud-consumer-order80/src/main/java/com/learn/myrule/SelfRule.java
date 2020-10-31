package com.learn.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SelfRule {

    @Bean
    public IRule getRule(){
        return new RandomRule();//定义为随机
    }
}
