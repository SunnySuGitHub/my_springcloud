package com.cloud.setting.Service;

import com.cloud.setting.Dao.LadderedElecpriceMapper;
import com.cloud.setting.Dao.LadderedWaterpriceMapper;
import com.cloud.setting.utils.result.Result;
import com.cloud.setting.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/11 9:33
 */
@Service
public class LadderPriceService {

    @Resource
    LadderedWaterpriceMapper waterLadder;

    @Resource
    LadderedElecpriceMapper ammeterLadder;

    public ResultData getWatermeterLadder(String enprNo, int waterType) {
        return Result.success(waterLadder.getLevels(enprNo, waterType));
    }

    public ResultData getAmmeterLadder(String enprNo, int voltageType) {
        return Result.success(ammeterLadder.getPriceList(enprNo, voltageType));
    }

}
