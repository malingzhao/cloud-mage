package com.mlz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mage
 * @date 2020-03-24 17:34
 */


@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
@EnableHystrix  //开启服务熔断
public class OrderHyxtrixFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHyxtrixFeignMain80.class, args);
    }
}
