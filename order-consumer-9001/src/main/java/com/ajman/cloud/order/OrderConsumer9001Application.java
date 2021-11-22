package com.ajman.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumer9001Application {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer9001Application.class,args);
    }
}
