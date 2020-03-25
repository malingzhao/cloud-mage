package com.mlz.springcloud.dao;


import com.mlz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 我们的主题是讲述springcloud
 */

//dao接口
@Mapper
@Repository
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
