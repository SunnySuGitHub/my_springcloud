package com.cloud.history.Controller;

import com.cloud.history.Service.AmmeterServices.AmmeterCostService;
import com.cloud.history.Service.AmmeterServices.AmmeterHistoryService;
import com.cloud.history.Service.AmmeterServices.AmmeterUsageService;
import com.cloud.history.Service.WatermeterServices.WatermeterCostService;
import com.cloud.history.Service.WatermeterServices.WatermeterHistorydataService;
import com.cloud.history.Service.WatermeterServices.WatermeterUsageService;
import com.cloud.history.utils.ResponseHandler;
import com.cloud.history.utils.result.Result;
import com.cloud.history.utils.result.ResultData;
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
    AmmeterUsageService ammeterUsageService;

    @Autowired
    AmmeterHistoryService ammeterHistoryService;

    @Autowired
    AmmeterCostService ammeterCostService;

    @Autowired
    WatermeterHistorydataService watermeterHistorydataService;

    @Autowired
    WatermeterUsageService watermeterUsageService;

    @Autowired
    WatermeterCostService watermeterCostService;

    /**
     * 查询单个水表历史读数记录
     */
    @GetMapping("/GetWatermeterHistorydata")
    public ResultData getWatermeterHistorydata(@RequestParam("meterNo") String meterNo,
                                               @RequestParam("enprNo") String enprNo,
                                               @RequestParam(value = "startDateLine", defaultValue = "-1") long startDateLine,
                                               @RequestParam(value = "endDateLine", defaultValue = "-1") long endDateLine) {

        if (StringUtils.isNotBlank(meterNo) && StringUtils.isNotBlank(enprNo)) {
            return ResponseHandler.doHandle(() -> watermeterHistorydataService.getWatermeterHistorydata(meterNo, enprNo, startDateLine, endDateLine));
        } else {
            return Result.error(HttpStatus.BAD_REQUEST, "参数错误");
        }
    }

    /**
     * 查询单个电表 各类型 历史读数记录
     * readType:
     * 0：总量
     * 1：尖峰
     * 2：峰
     * 3：平
     * 4：谷
     */
    @GetMapping("/GetAmmeterHistorydata")
    public ResultData getAmmeterHistorydata(@RequestParam("meterNo") String meterNo,
                                            @RequestParam("enprNo") String enprNo,
                                            @RequestParam("readType") int readType,
                                            @RequestParam(value = "startDateLine", defaultValue = "-1") long startDateLine,
                                            @RequestParam(value = "endDateLine", defaultValue = "-1") long endDateLine) {
        if (StringUtils.isNotBlank(meterNo) && StringUtils.isNotBlank(enprNo)) {
            return ResponseHandler.doHandle(() -> ammeterHistoryService.getAmmeterHistorydata(meterNo, enprNo, readType, startDateLine, endDateLine));
        } else {
            return Result.error(HttpStatus.BAD_REQUEST, "参数错误");
        }


    }

    /**
     * 查询水表每日 日用量记录
     */
    @GetMapping("GetWatermeterDailyUsage")
    public ResultData getWatermeterDailyUsage(@RequestParam("meterNo") String meterNo,
                                              @RequestParam("enprNo") String enprNo) {
        if (StringUtils.isNotBlank(meterNo) && StringUtils.isNotBlank(enprNo)) {
            return ResponseHandler.doHandle(() -> watermeterUsageService.getWatemeterDailyUsage(meterNo, enprNo));
        } else {
            return Result.error(HttpStatus.BAD_REQUEST, "参数缺失");
        }
    }

    /**
     * 查询电表 各类型每日 日用量记录
     * readType:
     * 0：总量
     * 1：尖峰
     * 2：峰
     * 3：平
     * 4：谷
     */
    @GetMapping("/GetAmmeterDailyUsage")
    public ResultData getAmmeterDailyUsage(@RequestParam("meterNo") String meterNo,
                                           @RequestParam("enprNo") String enprNo,
                                           @RequestParam("readType") int readType) {
        if (StringUtils.isNotBlank(meterNo) && StringUtils.isNotBlank(enprNo)) {
            return ResponseHandler.doHandle(() -> ammeterUsageService.getAmmeterDailyUsage(meterNo, enprNo, readType));
        } else {
            return Result.error(HttpStatus.BAD_REQUEST, "参数缺失");
        }
    }

    /**
     * 查询水表每日扣费记录
     */
    @GetMapping("/GetWatermeterDailyCost")
    public ResultData getWatermeterDailyCost(@RequestParam("meterNo") String meterNo,
                                             @RequestParam("enprNo") String enprNo) {
        if (StringUtils.isNotBlank(meterNo) && StringUtils.isNotBlank(enprNo)) {
            return ResponseHandler.doHandle(() -> watermeterCostService.getWatermeterDailyCost(meterNo, enprNo));
        } else {
            return Result.error(HttpStatus.BAD_REQUEST, "参数缺失");
        }
    }

    /**
     * 查询电表 各类型 每日扣费记录
     * 0：总量
     * 1：尖峰
     * 2：峰
     * 3：平
     * 4：谷
     */
    @GetMapping("/GetAmmeterDailyCost")
    public ResultData getAmmeterDailyCost(@RequestParam("ammeterNo") String ammeterNo,
                                           @RequestParam("enprNo") String enprNo,
                                          @RequestParam("readType") int readType) {
        if (StringUtils.isNotBlank(ammeterNo) && StringUtils.isNotBlank(enprNo)) {
            return ResponseHandler.doHandle(() -> ammeterCostService.getAmmeterDailyCost(ammeterNo, enprNo, readType));
        } else {
            return Result.error(HttpStatus.BAD_REQUEST, "参数缺失");
        }
    }



}
