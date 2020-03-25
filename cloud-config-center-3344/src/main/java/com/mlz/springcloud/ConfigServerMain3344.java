package com.mlz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Malingzhao
 * @date 2020-03-25 08:20
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain3344.class, args);
    }
}
