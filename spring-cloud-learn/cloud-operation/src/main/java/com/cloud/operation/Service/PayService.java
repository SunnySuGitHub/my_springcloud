package com.cloud.operation.Service;

import com.cloud.operation.Dao.PayhistoryMapper;
import com.cloud.operation.Dao.UserMapper;
import com.cloud.operation.Entity.Payhistory;
import com.cloud.operation.Entity.User;
import com.cloud.operation.utils.Constants;
import com.cloud.operation.utils.result.Result;
import com.cloud.operation.utils.result.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/27 16:06
 */
@Service
public class PayService {

    @Resource
    PayhistoryMapper payhistoryMapper;

    @Resource
    UserMapper userMapper;

    @Transactional
    public ResultData paySave(Payhistory payhistory) {
        payhistory.setPayTime(System.currentTimeMillis()/1000);
        payhistory.setPayStatus(Constants.PAY_FAILED);
        int id = payhistoryMapper.save(payhistory);
        User user = userMapper.findByUid(payhistory.getuId());
        user.setAccountBalance(user.getAccountBalance().add(payhistory.getPayAmount()));
        if(userMapper.uptUser(user) == 1) {
            Payhistory justNow = payhistoryMapper.findById(id);
            justNow.setPayStatus(Constants.PAY_SUCCEES);
            return Result.success(payhistoryMapper.update(justNow));
        } else {
            return Result.success("支付失败");
        }
    }

    public ResultData getPayHistory(String enprNo, long startLine, long endLine) {
        return Result.success(payhistoryMapper.getPayHistory(enprNo, startLine, endLine));
    }

    public ResultData getOperatorPayHistory(int operatorId, long startLine, long endLine) {
        return Result.success(payhistoryMapper.getOperatorPayHistory(operatorId, startLine, endLine));
    }

    public ResultData getUserPayHistory(int uId, long startLine, long endLine) {
        return Result.success(payhistoryMapper.getUserPayHistory(uId, startLine, endLine));
    }



}
