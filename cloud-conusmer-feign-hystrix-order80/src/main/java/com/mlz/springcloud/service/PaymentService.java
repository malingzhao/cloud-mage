package com.mlz.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 兜底的和业务逻辑的方法在一块
 * 兜底的方法
 * 导致代码的膨胀 业务逻辑的方法
 * 如何解决
 * 每一个业务方法对应一个兜底的方法
 */

/**
 * @author mage
 * @date 2020-03-24 17:35
 */
//


@Component
public class PaymentService {


    /**
     * 正常访问不会出现问题
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id :" + id + "\t" + "O(n_n)哈哈-";
    }

    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    public String paymentInfo_Timeout(Integer id) {
        int age = 10 / 0;

//        int timeNumber = 5;


//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id :" + id +
                "\t" + "O(n_n)哈哈-" + "耗时3s钟";
    }


}