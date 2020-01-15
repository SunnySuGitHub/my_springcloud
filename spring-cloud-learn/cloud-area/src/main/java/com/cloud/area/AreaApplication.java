package com.cloud.area;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/13 15:09
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class AreaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AreaApplication.class, args);
    }
}
