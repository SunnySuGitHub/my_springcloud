package com.cloud.setting.Service;

import com.cloud.setting.Dao.RepairMapper;
import com.cloud.setting.Entity.Repair;
import com.cloud.setting.utils.result.Result;
import com.cloud.setting.utils.result.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/20 10:57
 */
@Service
public class RepairService {

    @Resource
    RepairMapper repairMapper;

    public ResultData add(Repair repair) {
        repair.setSubmitTime(System.currentTimeMillis() / 1000);
        return Result.success(repairMapper.save(repair));
    }

    public ResultData list(String enprNo, int state) {
        List<Repair> repairList = repairMapper.list(enprNo, state);
        return Result.success(repairList);
    }

    public ResultData upt(Repair repair) {
        if (repair.getRepairId() == null) {
            return Result.error(HttpStatus.BAD_REQUEST, "参数不规范");
        } else {
            return Result.success(repairMapper.uptRepair(repair));
        }
    }
}