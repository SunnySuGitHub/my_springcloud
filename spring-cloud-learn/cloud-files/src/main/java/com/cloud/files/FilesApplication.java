package com.cloud.files;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/13 9:45
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDistributedTransaction
public class FilesApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilesApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
