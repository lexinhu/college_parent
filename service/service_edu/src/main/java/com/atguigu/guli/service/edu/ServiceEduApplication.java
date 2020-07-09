package com.atguigu.guli.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 乐心湖
 * @date 2020/6/23 1:25
 **/
@SpringBootApplication
@ComponentScan({"com.atguigu.guli"})
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceEduApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEduApplication.class, args);
    }
}
