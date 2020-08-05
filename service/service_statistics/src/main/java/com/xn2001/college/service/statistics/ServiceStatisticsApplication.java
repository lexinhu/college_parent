package com.xn2001.college.service.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 乐心湖
 * @date 2020/8/5 0:44
 **/
@SpringBootApplication
@ComponentScan({"com.xn2001.college"})
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class ServiceStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStatisticsApplication.class, args);
    }
}
