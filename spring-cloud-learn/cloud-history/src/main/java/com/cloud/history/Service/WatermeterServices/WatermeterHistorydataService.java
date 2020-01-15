package com.cloud.history.Service.WatermeterServices;

import com.cloud.history.Dao.WatermeterHistoryMapper;
import com.cloud.history.utils.result.Result;
import com.cloud.history.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/23 17:08
 */
@Service
public class WatermeterHistorydataService {

    @Resource
    WatermeterHistoryMapper watermeterHistoryMapper;


    public ResultData getWatermeterHistorydata(String meterNo, String enprNo, long startLine, long endLine) {
        return Result.success(watermeterHistoryMapper.getWatermeterHistoryByMeterNo(meterNo, enprNo, startLine, endLine));
    }

    public BigDecimal getLatestRecordByMeterNo(String meterNo, String enprNo) {
        return watermeterHistoryMapper.getLatestRecordByMeterNo(meterNo, enprNo);
    }
}
