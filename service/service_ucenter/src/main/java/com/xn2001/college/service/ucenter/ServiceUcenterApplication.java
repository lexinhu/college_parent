package com.xn2001.college.service.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 乐心湖
 * @date 2020/7/29 19:37
 **/
@SpringBootApplication
@ComponentScan({"com.xn2001.college"})
@EnableDiscoveryClient
public class ServiceUcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUcenterApplication.class, args);
    }
}
