package com.cloud.history.Service.AmmeterServices;

import com.cloud.history.Dao.AmmeterHistoryMapper;
import com.cloud.history.utils.result.Result;
import com.cloud.history.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/23 19:43
 */
@Service
public class AmmeterHistoryService {

    @Resource
    AmmeterHistoryMapper ammeterHistoryMapper;

    public ResultData getAmmeterHistorydata(String meterNo, String enprNo, int readType, long startLine, long endLine) {
        return Result.success(ammeterHistoryMapper.getAmmeterHistorydata(meterNo, enprNo, readType, startLine, endLine));
    }


}
