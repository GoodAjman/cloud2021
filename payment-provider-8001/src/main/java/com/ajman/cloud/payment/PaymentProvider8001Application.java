package com.ajman.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProvider8001Application.class, args);
    }

}
