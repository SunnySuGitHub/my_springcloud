package com.cloud.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/13 9:45
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
