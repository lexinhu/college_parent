package com.xn2001.college.service.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 乐心湖
 * @date 2020/8/2 22:18
 **/
@SpringBootApplication
@ComponentScan({"com.xn2001.college"})
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceTradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTradeApplication.class, args);
    }
}
