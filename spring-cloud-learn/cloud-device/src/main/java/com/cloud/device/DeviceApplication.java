package com.cloud.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/13 15:09
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class DeviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeviceApplication.class, args);
    }

    @RequestMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "forwei") String name){
        return "hello" + name;
    }
}
