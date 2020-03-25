package com.mlz.springcloud.controller;

import com.mlz.springcloud.service.PaymentHyxtrixService;
import com.mlz.springcloud.service.PaymentService;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mage
 * @date 2020-03-24 17:38
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHyxtrixService paymentHyxtrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHyxtrixService.paymentInfo_OK(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/ok/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutFallbackMethod",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentHyxtrixService.paymentInfo_Timeout(id);
        log.info("****result:" + result);
        return result;
    }

    public String paymentInfo_TimeoutFallbackMethod(@PathVariable("id") Integer id) {

        return "我是消费者80,对方支付系统繁忙， 请10s钟之后重试 或者自己出错请检查自己哈哈";
    }


//下面是全局的fallback


    public String payment_FallbackMethod() {
        return "Global异常处理信息， 请稍后再试,mmmmmmmm";
    }

}
