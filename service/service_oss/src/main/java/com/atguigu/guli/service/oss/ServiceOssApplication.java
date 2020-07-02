package com.atguigu.guli.service.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 乐心湖
 * @date 2020/6/30 20:41
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动配置
@ComponentScan({"com.atguigu.guli"})
public class ServiceOssApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOssApplication.class, args);
    }

}
