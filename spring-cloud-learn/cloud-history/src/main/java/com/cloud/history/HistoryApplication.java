package com.cloud.history;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/13 9:45
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class HistoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(HistoryApplication.class, args);
    }

    @RequestMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "forwei") String name) {
        return "hello his" + name;
    }
}
