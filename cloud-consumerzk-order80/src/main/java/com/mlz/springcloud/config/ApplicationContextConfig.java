package com.mlz.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author mage
 * @date 2020-03-24 12:35
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 使用自定义的负载均衡算法
     * @return
     */
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
    return new RestTemplate();
    }
}
