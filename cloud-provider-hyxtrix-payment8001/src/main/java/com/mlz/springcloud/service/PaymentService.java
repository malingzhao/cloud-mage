package com.mlz.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author mage
 * @date 2020-03-24 16:54
 */

@Service
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

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
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


    public String paymentInfo_TimeoutHandler(Integer id) {

//        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeoutHandler,id :" + id +
//                "\t" + "O(n_n)哈哈-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";


        return  "线程池:" + Thread.currentThread().getName() + "系统繁忙或运行报错， 请稍后再试:id , id "+"\t"+"af;lhns;algvvvvvhn";
    }


    /**
     * 假设10次请求6次失败的话 那么这个就失效 跳闸
     * @param id
     * @return
     */
    //========服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"), //时间 窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="60") // 失败率达到多少会跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功， 流水号:" + serialNumber;
    }






    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试,id:" + id ;
    }



}
