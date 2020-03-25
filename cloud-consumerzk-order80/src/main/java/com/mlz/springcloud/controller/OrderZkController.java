package com.mlz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author mage
 * @date 2020-03-24 12:36
 */

@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URl = "http://cloud-provider-paymnet";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URl + "/payment/zk",String.class);
        return result;
    }

}
