package com.mlz.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mage
 * @date 2020-03-24 20:15
 */

@Component
@FeignClient(value="CLOUD-PROVIDER-HYXTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentHyxtrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout/ok/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id );
}


