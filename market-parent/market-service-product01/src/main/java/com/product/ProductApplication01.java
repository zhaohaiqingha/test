package com.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 次注解:表示次项目是注册中心的客户端
@MapperScan("com.product.mapper")
public class ProductApplication01 {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication01.class,args);
    }
}
