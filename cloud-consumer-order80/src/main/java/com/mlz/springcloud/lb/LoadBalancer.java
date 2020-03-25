package com.mlz.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author mage
 * @date 2020-03-24 15:02
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
