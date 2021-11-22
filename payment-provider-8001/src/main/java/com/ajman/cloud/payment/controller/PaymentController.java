package com.ajman.cloud.payment.controller;

import com.ajman.cloud.common.entites.CommonResult;
import com.ajman.cloud.common.entites.Payment;
import com.ajman.cloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @auther zzyy
 * @create 2020-02-18 10:43
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        if(result>0) return new CommonResult(200,"插入数据库成功"+serverPort,result);
        return new CommonResult(203,"插入数据失败",null);
    }

    @RequestMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment result=paymentService.getPaymentById(id);
        if(ObjectUtils.isEmpty(result)) return new CommonResult(203,"查询失败或者数据为空"+serverPort,result);
        return new CommonResult(200,"查询数据成功"+serverPort,result);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("****** elemt:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance getElement:"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }




}
