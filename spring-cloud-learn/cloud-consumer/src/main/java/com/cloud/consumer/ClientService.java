package com.cloud.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/19 16:47
 */
@FeignClient("cloud-service")
@Service
public interface ClientService {

    @GetMapping("/hello")
    String test(@RequestParam("name") String name);

}
