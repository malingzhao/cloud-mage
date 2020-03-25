package com.mlz.sprigncloud.service;

import com.mlz.springcloud.entities.CommonResult;
import com.mlz.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mage
 * @date 2020-03-24 15:53
 */

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id);


    @GetMapping(value="/payment/feign/timeout")
    public  String paymentFeignTimeout();
}
