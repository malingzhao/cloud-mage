package com.mlz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Malingzhao
 * @date 2020-03-24 21:50
 */


@SpringBootApplication
@EnableEurekaClient
@LoadBalancerClients
@EnableDiscoveryClient
public class Gatewaymain9527 {
    public static void main(String[] args) {
        SpringApplication.run(Gatewaymain9527.class,args);
    }
}

