package com.cloud.device.Service;

import com.cloud.device.Dao.AmmeterMapper;
import com.cloud.device.Dao.CenterMapper;
import com.cloud.device.Dao.WaterMeterMapper;
import com.cloud.device.Entity.Center;
import com.cloud.device.utils.result.Result;
import com.cloud.device.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/11 15:21
 */
@Service
public class CenterService {

    @Resource
    CenterMapper centerMapper;

    @Resource
    WaterMeterMapper waterMeterMapper;

    @Resource
    AmmeterMapper ammeterMapper;

    public ResultData addCenter(Center center) {
        center.setCreateTime(System.currentTimeMillis() / 1000);
        return Result.success(centerMapper.save(center));
    }

    public ResultData delCenter(int id) {
        return Result.success(centerMapper.delete(id));
    }

    public ResultData getCenterByEnprNo(String enprNo) {
        return Result.success(centerMapper.getCenterByEnprNo(enprNo));
    }

    public ResultData getCenterByCid(int cId) {
        return Result.success(centerMapper.getCenterByCid(cId));
    }

    public ResultData getWatermeterByCenter(int centerId) {
        return Result.success(waterMeterMapper.getWatermeterByCenter(centerId));
    }

    public ResultData getAmmeterByCenter(int centerId) {
        return Result.success(ammeterMapper.getAmmeterByCenter(centerId));
    }


}
