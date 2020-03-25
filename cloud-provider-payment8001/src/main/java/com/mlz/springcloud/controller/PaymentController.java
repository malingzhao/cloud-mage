package com.mlz.springcloud.controller;

import com.mlz.springcloud.entities.CommonResult;
import com.mlz.springcloud.entities.Payment;
import com.mlz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


//controller service dao
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    //客户端通过外部的方式访问我们
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    //客户端通过外部的方式访问我们
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentByIdt(@PathVariable("id") long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果" + payment + "\t" + "大家好");
        if (payment != null) {
            return new CommonResult(200, "查询成功, serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录 查询ID", null);
        }
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }



    @GetMapping(value="/payment/feign/timeout")
    public  String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
