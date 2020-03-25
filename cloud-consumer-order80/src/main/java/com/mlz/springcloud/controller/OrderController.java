package com.mlz.springcloud.controller;

import com.mlz.springcloud.entities.CommonResult;
import com.mlz.springcloud.entities.Payment;
import com.mlz.springcloud.lb.LoadBalancer;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URl="http://localhost:8001";
    public static final String PAYMENT_URl = "http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    //代表调用
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URl + "/payment/create", payment,
                CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYMENT_URl + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {

        ResponseEntity<CommonResult> entity =
                restTemplate.getForEntity(PAYMENT_URl + "/payment/get/" + id, CommonResult.class);

        if (entity.getStatusCode().is2xxSuccessful()) {
//            log.info(entity.getStatusCode()+"\t" + entity.getHeaders());
            return entity.getBody();
        } else {
            return new CommonResult<Payment>(444, "操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances =
                discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
//            System.out.println("service 出现异常 不能检测到实例");
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        System.out.println(serviceInstance.toString());
        URI uri = serviceInstance.getUri();
        System.out.println(uri+"============================================");
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
