package com.cloud.history.Service.WatermeterServices;

import com.cloud.history.Dao.WatermeterCostMapper;
import com.cloud.history.utils.result.Result;
import com.cloud.history.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/25 15:44
 */
@Service
public class WatermeterCostService {

    @Resource
    WatermeterCostMapper watermeterCostMapper;

    public ResultData getWatermeterDailyCost(String meterNo, String enprNo){
        return Result.success(watermeterCostMapper.getWatermeterDailyCost(meterNo, enprNo));
    }



}
