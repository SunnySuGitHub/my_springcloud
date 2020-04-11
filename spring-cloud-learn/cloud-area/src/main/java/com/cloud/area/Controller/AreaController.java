package com.cloud.area.Controller;

import com.cloud.area.Entity.Block;
import com.cloud.area.Entity.Community;
import com.cloud.area.Service.BlockService;
import com.cloud.area.Service.CommunityService;
import com.cloud.area.utils.ResponseHandler;
import com.cloud.area.utils.result.Result;
import com.cloud.area.utils.result.ResultData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/19 16:34
 * 区域相关操作
 */
@RestController
@CrossOrigin("*")
public class AreaController {

    @Autowired
    CommunityService communityService;

    @Autowired
    BlockService blockService;

    /**
     * 获取小区信息
     */
    @GetMapping("/community")
    public ResultData getCommunity(@RequestParam(value = "cId", defaultValue = "-1") int id) {
        return ResponseHandler.doHandle(() -> communityService.getCommunity(id));
    }

    /**
     * 增加小区信息
     */
    @PostMapping("/community")
    public ResultData addCommunity(@RequestBody Community community) {
        return ResponseHandler.doHandle(() -> communityService.addCommunity(community));
    }

    /**
     * 删除小区信息
     */
    @DeleteMapping("/community")
    public ResultData delCommunity(@RequestParam(value = "cId", defaultValue = "-1") int id) {
        return ResponseHandler.doHandle(() -> communityService.delCommunity(id));
    }

    /**
     * 更改小区信息
     */
    @PutMapping("/community")
    public ResultData uptCommunity(@RequestBody Community community) {
        return ResponseHandler.doHandle(() -> communityService.uptCommunity(community));
    }

    /**
     * 获取公司下所有小区信息
     */
    @GetMapping("/community/list")
    public ResultData communityList(@RequestParam("enprNo") String enprNo) {
        if (StringUtils.isNotBlank(enprNo))
            return ResponseHandler.doHandle(() -> communityService.communityList(enprNo));
        return Result.error(HttpStatus.BAD_REQUEST, "缺失公司编码");
    }

    /**
     * 获取小区下的所有楼栋信息
     */
    @GetMapping("/block/list")
    public ResultData getBlockList(@RequestParam(value = "cId", defaultValue = "-1") int cid) {
        return ResponseHandler.doHandle(() -> blockService.getBlockByCid(cid));
    }

    /**
     * 获取楼栋信息
     */
    @GetMapping("/block")
    public ResultData getBlock(@RequestParam(value = "bId", defaultValue = "-1") int bid) {
        return ResponseHandler.doHandle(() -> blockService.getBlock(bid));
    }

    /**
     * 删除楼栋信息
     */
    @DeleteMapping("/block")
    public ResultData delBlock(@RequestParam(value = "bId", defaultValue = "-1") int bid) {
        return ResponseHandler.doHandle(() -> blockService.delBlock(bid));
    }

    /**
     * 更改楼栋信息
     */
    @PutMapping("/block")
    public ResultData uptBlock(@RequestBody Block block) {
        return ResponseHandler.doHandle(() -> blockService.uptBlock(block));
    }
}
