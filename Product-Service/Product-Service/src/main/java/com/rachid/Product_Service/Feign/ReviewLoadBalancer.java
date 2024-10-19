package com.rachid.Product_Service.Feign;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;


@LoadBalancerClient(value="Review-Service")
public class ReviewLoadBalancer {
    @Bean
    @LoadBalanced
    Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
