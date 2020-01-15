package com.cloud.history.Service.AmmeterServices;

import com.cloud.history.Dao.AmmeterCostMapper;
import com.cloud.history.utils.result.Result;
import com.cloud.history.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/23 23:00
 */
@Service
public class AmmeterCostService {

    @Resource
    AmmeterCostMapper ammeterCostMapper;

    public ResultData getAmmeterDailyCost(String meterNo, String enprNo, int readType){
        switch (readType) {
            case 0: return Result.success(ammeterCostMapper.getAmmeterTotalDailyCost(meterNo, enprNo));
            case 1: return Result.success(ammeterCostMapper.getAmmeterSharpDailyCost(meterNo, enprNo));
            case 2: return Result.success(ammeterCostMapper.getAmmeterPeekDailyCost(meterNo, enprNo));
            case 3: return Result.success(ammeterCostMapper.getAmmeterFlatDailyCost(meterNo, enprNo));
            case 4: return Result.success(ammeterCostMapper.getAmmeterLowDailyCost(meterNo, enprNo));
            default: return Result.success(null);
        }
    }

}
