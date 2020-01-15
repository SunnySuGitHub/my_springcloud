package com.cloud.history.Service.AmmeterServices;

import com.cloud.history.Dao.AmmeterUsageMapper;
import com.cloud.history.utils.result.Result;
import com.cloud.history.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/23 19:05
 */
@Service
public class AmmeterUsageService {

    @Resource
    AmmeterUsageMapper ammeterUsageMapper;

    public ResultData getAmmeterDailyUsage(String ammeterNo, String enprNo, int readType){
        switch (readType) {
            case 0: return Result.success(ammeterUsageMapper.getAmmeterTotalDailyUsage(ammeterNo, enprNo));
            case 1: return Result.success(ammeterUsageMapper.getAmmeterSharpDailyUsage(ammeterNo, enprNo));
            case 2: return Result.success(ammeterUsageMapper.getAmmeterPeekDailyUsage(ammeterNo, enprNo));
            case 3: return Result.success(ammeterUsageMapper.getAmmeterFlatDailyUsage(ammeterNo, enprNo));
            case 4: return Result.success(ammeterUsageMapper.getAmmeterLowDailyUsage(ammeterNo, enprNo));
            default: return Result.success(null);
        }
    }

    public ResultData getCommunityUsage(int cid, long startLine, long endLine, String enprNo) {
        BigDecimal now = ammeterUsageMapper.getCommunityUsage(cid, startLine, endLine, enprNo);
        now = now == null ? BigDecimal.ZERO : now;
        return Result.success(now);
    }
}
