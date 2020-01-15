package com.cloud.device.Controller;

import com.cloud.device.Service.AmmeterService;
import com.cloud.device.Service.WaterMeterService;
import com.cloud.device.utils.Constants;
import com.cloud.device.utils.ResponseHandler;
import com.cloud.device.utils.result.Result;
import com.cloud.device.utils.result.ResultData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * @author: suxinyu
 * @DateTme: 2019/11/19 9:29
 * 表计相关操作
 */
@RestController
@CrossOrigin("*")
public class MeterController {


    @Autowired
    AmmeterService ammeterService;

    @Autowired
    WaterMeterService waterMeterService;

    /**
     * 删除表
     * 0为水表  1为电表
     */
    @DeleteMapping("/meter")
    public ResultData delMeter(@RequestParam("enprNo") String enprNo,
                               @RequestParam("meterNo") String meterNo,
                               @RequestParam("meterType") int meterType) {
        if (meterType == Constants.TYPE_WATERMETER) {
            return ResponseHandler.doHandle(() -> waterMeterService.deleteMeter(meterNo, enprNo));
        } else {
            return ResponseHandler.doHandle(() -> ammeterService.deleteMeter(meterNo, enprNo));
        }
    }

    /**
     * 更新表记数据
     * 0为水表  1为电表
     */
    @GetMapping("/refreshMeter")
    public ResultData refreshMeter(@RequestParam("enprNo") String enprNo,
                                   @RequestParam("meterType") int meterType) {
        if (meterType == Constants.TYPE_WATERMETER) {
            return ResponseHandler.doHandle(() -> waterMeterService.refreshMeter(enprNo));
        } else {
            return ResponseHandler.doHandle(() -> ammeterService.refreshMeter(enprNo));
        }
    }



    /**
     * 根据表编号和公司编码查看表计信息
     * 0为水表  1为电表
     */
    @GetMapping("/GetMeterDetailByMeterNoAndEnprNo")
    public ResultData getMeterDetail(@RequestParam("meterNo") String meterNo,
                                     @RequestParam("enprNo") String enprNo,
                                     @RequestParam(value = "meterType", defaultValue = "1") int meterType) {
        if (StringUtils.isNotBlank(meterNo) && StringUtils.isNotBlank(enprNo)) {
            if (meterType == Constants.TYPE_WATERMETER) {
                return ResponseHandler.doHandle(() -> waterMeterService.getWaterMeterDetail(meterNo, enprNo));
            } else {
                return ResponseHandler.doHandle(() -> ammeterService.getAmmeterDetail(meterNo, enprNo));
            }
        } else {
            return Result.error(HttpStatus.BAD_REQUEST, "参数缺失");
        }

    }

    /**
     * 根据公司编码查看各种状态所有表计信息
     * 0为水表  1为电表
     */
    @GetMapping("/GetAllMeterDetailByEnprNoAndState")
    public ResultData getMeterDetail(@RequestParam("enprNo") String enprNo,
                                     @RequestParam(value = "meterType", defaultValue = "1") int meterType,
                                     @RequestParam(value = "state", defaultValue = "-1") int state) {
        if (StringUtils.isNotBlank(enprNo)) {
            if (meterType == Constants.TYPE_WATERMETER) {
                return ResponseHandler.doHandle(() -> waterMeterService.getAllWaterMeterDetail(enprNo, state));
            } else {
                return ResponseHandler.doHandle(() -> ammeterService.getAllAmmeterDetail(enprNo, state));
            }
        } else {
            return Result.error(HttpStatus.BAD_REQUEST, "参数缺失");
        }

    }

    /**
     * 根据用户id查询特定表信息
     * 0为水表  1为电表
     */
    @GetMapping("/GetMeterDetailByUid")
    public ResultData getMeterDetailByUsernameAndEnprNo(@RequestParam(value = "uId", defaultValue = "1") int uid,
                                                        @RequestParam(value = "meterType", defaultValue = "1") int meterType) {
        if (meterType == Constants.TYPE_WATERMETER) {
            return ResponseHandler.doHandle(() -> waterMeterService.getWatermeterByUid(uid));
        } else {
            return ResponseHandler.doHandle(() -> ammeterService.getAmmeterByUid(uid));
        }
    }

}
