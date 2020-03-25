package com.mlz.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author mage
 * @date 2020-03-24 21:19
 */

@SpringBootApplication
@EnableHystrixDashboard
public class HyxtrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HyxtrixDashboardMain9001.class, args);
    }


}
