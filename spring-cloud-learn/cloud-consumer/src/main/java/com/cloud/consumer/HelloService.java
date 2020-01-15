package com.cloud.consumer;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wei.li
 * on 2019/2/26
 */

@Service
public class HelloService {

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    ClientService clientService;

    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public String hello(String name) throws Exception{
//        return restTemplate.getForObject("http://CLOUD-DEVICE/hello?name="+name, String.class);
//        return clientService.test(name);
        return name;
//        throw new Exception("error");
    }

}

