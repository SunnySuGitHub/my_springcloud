package com.cloud.setting.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cloud.setting.Dao.OperatorMapper;
import com.cloud.setting.Entity.Operator;
import com.cloud.setting.utils.JedisUtil;
import com.cloud.setting.utils.TokenUtil;
import com.cloud.setting.utils.result.Result;
import com.cloud.setting.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/18 20:13
 */
@Service
public class OperatorService {

    @Resource
    OperatorMapper operatorMapper;

    @Autowired
    JedisUtil jedisUtil;

    public ResultData login(String account, String password, String enprNo){
        Operator operator = operatorMapper.login(account, password, enprNo);
        String token = TokenUtil.GetToken();
        operator.setToken(token);
        jedisUtil.set("token_"+operator.getOperatorId(), token, 1800);
        if(operator == null){
            return Result.error(HttpStatus.BAD_REQUEST, "不存在此管理员");
        } else {
            return Result.success(operator);
        }
    }

    public ResultData getOperator(int id, String enprNo){
        if(id == -1){
            return Result.error(HttpStatus.BAD_REQUEST, "参数不规范");
        }
        if(jedisUtil.hGet(enprNo, "OperatorId"+id) == null) {
            Operator operator = operatorMapper.getOperator(id);
            jedisUtil.hSet(enprNo, "OperatorId"+id, JSON.toJSONString(operator));
            return Result.success(operator);
        } else {
            Operator operator = JSON.parseObject(jedisUtil.hGet(enprNo, "OperatorId"+id), Operator.class);
            return Result.success(operator);
        }
    }

    public ResultData addOperator(Operator operator){
        if(operator.getOperatorType() == null){
            return Result.error(HttpStatus.BAD_REQUEST, "参数不规范");
        } else {
            String enprNo = operator.getEnprNo();
            jedisUtil.hDel(enprNo, "OperatorList");
            jedisUtil.sadd("blacklist_"+operator.getOperatorId(), null);
            return Result.success(operatorMapper.addOperator(operator));
        }
    }

    public ResultData uptOperator(Operator operator){
        if(operator.getOperatorId() == null){
            return Result.error(HttpStatus.BAD_REQUEST, "参数不规范");
        } else {
            String enprNo = operator.getEnprNo();
            jedisUtil.hDel(enprNo, "OperatorId"+operator.getOperatorId());
            jedisUtil.hDel(enprNo, "OperatorList");
            return Result.success(operatorMapper.uptOperator(operator));
        }
    }

    public ResultData delOperator(int id, String enprNo){
        if(id == -1){
            return Result.error(HttpStatus.BAD_REQUEST, "参数不规范");
        } else {
            int res = operatorMapper.delOperator(id);
            jedisUtil.hDel(enprNo, "OperatorId"+id);
            jedisUtil.hDel(enprNo, "OperatorList");
            if(res == 1) return Result.success("删除成功");
            return Result.error(HttpStatus.INTERNAL_SERVER_ERROR, "删除失败");

        }
    }

    public ResultData operatorList(String enprNo){
        if(jedisUtil.hGet(enprNo, "OperatorList") == null) {
            List<Operator> operatorList = operatorMapper.operatorList(enprNo);
            String operatorDetailList = JSONArray.toJSONString(operatorList);
            jedisUtil.hSet(enprNo, "OperatorList", operatorDetailList);
            return Result.success(operatorList);
        } else {
            String res = jedisUtil.hGet(enprNo, "OperatorList");
            List<Operator> operators = JSONArray.parseArray(res, Operator.class);
            return Result.success(operators);
        }
    }


}
