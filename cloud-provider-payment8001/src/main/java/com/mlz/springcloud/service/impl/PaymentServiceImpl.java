package com.mlz.springcloud.service.impl;

import com.mlz.springcloud.dao.PaymentDao;
import com.mlz.springcloud.entities.Payment;
import com.mlz.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl  implements PaymentService {

    //java代码 能够进行依赖的注入
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }


}
