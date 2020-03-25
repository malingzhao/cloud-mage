package com.mlz.sprigncloud.controller;

import com.mlz.sprigncloud.service.PaymentFeignService;
import com.mlz.springcloud.entities.CommonResult;
import com.mlz.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mage
 * @date 2020-03-24 15:56
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping(value="/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign  客户端一般默认等待1s
        return paymentFeignService.paymentFeignTimeout();
    }
}
