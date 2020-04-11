package com.cloud.setting.Controller;

import com.cloud.setting.Entity.AmmeterRate;
import com.cloud.setting.Entity.Notice;
import com.cloud.setting.Entity.Repair;
import com.cloud.setting.Service.LadderPriceService;
import com.cloud.setting.Service.NoticeService;
import com.cloud.setting.Service.RateService;
import com.cloud.setting.Service.RepairService;
import com.cloud.setting.utils.ResponseHandler;
import com.cloud.setting.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/27 21:13
 * 日常小区/公司管理相关
 */
@RestController
@CrossOrigin("*")
public class ManagementController {

    @Autowired
    RepairService repairService;

    @Autowired
    NoticeService noticeService;

    @Autowired
    LadderPriceService ladderPriceService;

    @Autowired
    RateService rateService;


    /**
     * 用户报修
     */
    @PostMapping("/repair")
    public ResultData repair(@RequestBody Repair repair) {
        return ResponseHandler.doHandle(() -> repairService.add(repair));
    }

    /**
     * 查看公司报修单
     */
    @GetMapping("/repair/list")
    public ResultData list(@RequestParam("enprNo") String enprNo,
                           @RequestParam(value = "state", defaultValue = "-1") int state) {
        return ResponseHandler.doHandle(() -> repairService.list(enprNo, state));
    }

    /**
     * 报修进度更新
     */
    @PutMapping("/repair")
    public ResultData upt(@RequestBody Repair repair) {
        return ResponseHandler.doHandle(() -> repairService.upt(repair));
    }

    /**
     * 发布公告
     */
    @PostMapping("/notice")
    public ResultData addNotice(@RequestBody Notice notice) {
        return ResponseHandler.doHandle(() -> noticeService.addNotice(notice));
    }

    /**
     * 查看公告发布历史
     */
    @GetMapping("/notice/list")
    public ResultData noticeList(@RequestParam("enprNo") String enprNo) {
        return ResponseHandler.doHandle(() -> noticeService.noticeList(enprNo));
    }

    /**
     * 编辑公告
     */
    @PutMapping("/notice")
    public ResultData noticeList(@RequestBody Notice notice) {
        return ResponseHandler.doHandle(() -> noticeService.uptNotice(notice));
    }

    /**
     * 删除公告
     */
    @DeleteMapping("/notice")
    public ResultData delNotice(@RequestParam("id") int id,
                                @RequestParam("enprNo") String enprNo) {
        return ResponseHandler.doHandle(() -> noticeService.delNotice(id, enprNo));
    }

    /**
     * 获取阶梯水价
     *
     * @param enprNo
     * @param waterType 水表类型
     *                  1 居民生活用水
     *                  2 工业用水
     *                  3 行政事业单位用水
     *                  4 经营用水
     *                  5 特种行业用水
     */
    @GetMapping("/ladder/watermeter")
    public ResultData getWatermeterLadder(@RequestParam("enprNo") String enprNo,
                                          @RequestParam("waterType") int waterType) {
        return ResponseHandler.doHandle(() -> ladderPriceService.getWatermeterLadder(enprNo, waterType));
    }

    /**
     * 获取阶梯电价
     */
    @GetMapping("/ladder/ammeter")
    public ResultData getAmmeterLadder(@RequestParam("enprNo") String enprNo,
                                       @RequestParam("voltageType") int vType) {
        return ResponseHandler.doHandle(() -> ladderPriceService.getAmmeterLadder(enprNo, vType));
    }

    /**
     * 获取电表不同费率
     * 0：总量
     * 1：尖峰
     * 2：峰
     * 3：平
     * 4：谷
     */
    @GetMapping("/rate/ammeter")
    public ResultData getAmmeterRate(@RequestParam("enprNo") String enprNo) {
        return ResponseHandler.doHandle(() -> rateService.getRateList(enprNo));
    }

    /**
     * 修改电表费率
     */
    @PutMapping("/rate/ammeter")
    public ResultData getAmmeterRate(@RequestBody AmmeterRate ammeterRate) {
        return ResponseHandler.doHandle(() -> rateService.uptRate(ammeterRate));
    }


}
