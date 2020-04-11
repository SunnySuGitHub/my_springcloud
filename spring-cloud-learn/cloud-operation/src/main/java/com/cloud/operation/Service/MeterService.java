package com.cloud.operation.Service;

import com.cloud.operation.utils.result.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("cloud-device")
@Service
public interface MeterService {

    @GetMapping("/GetMeterDetailByUid")
    ResultData getMeterDetailByUid(@RequestParam("uId") int uid, @RequestParam("meterType") int meterType);

}
