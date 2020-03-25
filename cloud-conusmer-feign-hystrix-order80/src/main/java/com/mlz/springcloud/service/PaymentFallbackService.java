package com.mlz.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mage
 * @date 2020-03-24 20:17
 */

@Component
public class PaymentFallbackService  implements  PaymentHyxtrixService{


    public String paymentInfo_OK(Integer id) {
        return "------------------PaymentFallbackService fall back-payment  paymentInfo_OK ok";
    }


    public String paymentInfo_Timeout(Integer id) {
        return "--------------PaymentFallbackervice falll back-payment paymentInfo_Timeout Timeout " ;
    }
}
