package com.mlz.sprigncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mage
 * @date 2020-03-24 15:53
 */


@SpringBootApplication
//使用feign激活并开启
@EnableFeignClients
public class OrderOpenfeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignMain80.class, args);
    }
}
