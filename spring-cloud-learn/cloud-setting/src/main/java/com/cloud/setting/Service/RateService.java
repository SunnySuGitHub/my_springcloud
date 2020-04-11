package com.cloud.setting.Service;

import com.cloud.setting.Dao.AmmeterRateMapper;
import com.cloud.setting.Entity.AmmeterRate;
import com.cloud.setting.utils.result.Result;
import com.cloud.setting.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/11 15:05
 */
@Service
public class RateService {

    @Resource
    AmmeterRateMapper rateMapper;

    public ResultData getRateList(String enprNo) {
        return Result.success(rateMapper.getRateList(enprNo));
    }

    public ResultData uptRate(AmmeterRate ammeterRate) {
        return Result.success(rateMapper.updateRate(ammeterRate));
    }


}
