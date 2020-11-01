package com.learn.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SperaX
 * @version 1.0
 * @date 2020/11/1 18:36
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //http://news.baidu.com/guonei
        routes.route("path_route_1",r->r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route("path_route_2",r->r.path("/guoji").uri("http://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }
}
