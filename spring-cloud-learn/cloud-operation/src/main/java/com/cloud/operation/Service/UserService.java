package com.cloud.operation.Service;

import com.alibaba.fastjson.JSONArray;
import com.cloud.operation.Dao.UserMapper;
import com.cloud.operation.Entity.UserInfoVo;
import com.cloud.operation.utils.Constants;
import com.cloud.operation.utils.JedisUtil;
import com.cloud.operation.utils.result.Result;
import com.cloud.operation.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/18 15:43
 */
@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    @Autowired
    JedisUtil jedisUtil;

    @Autowired
    MeterService meterService;

    public ResultData getUserInfoByBlockId(int bId, String enprNo) {
        List<Integer> uids = userMapper.findUidsByBid(bId);
        List<UserInfoVo> res = new ArrayList<>();
        for (int uid : uids) {
            if (jedisUtil.hGet(enprNo, "UserInfoUid" + uid) == null) {
                List<UserInfoVo> infoVo = userMapper.findUserInfoVoByUid(uid);
                jedisUtil.hSet(enprNo, "UserInfoUid" + uid, JSONArray.toJSONString(infoVo));
                res.addAll(infoVo);
            } else {
                List<UserInfoVo> infoVo = JSONArray.parseArray(jedisUtil.hGet(enprNo, "UserInfoUid" + uid), UserInfoVo.class);
                res.addAll(infoVo);
            }
        }
        return Result.success(res);
    }

    public ResultData getUserInfoByUid(int uid, String enprNo) {
        if (jedisUtil.hGet(enprNo, "UserInfoUid" + uid) == null) {
            List<UserInfoVo> infoVos = userMapper.findUserInfoVoByUid(uid);
            jedisUtil.hSet(enprNo, "UserInfoUid" + uid, JSONArray.toJSONString(infoVos));
            return Result.success(infoVos);
        } else {
            List<UserInfoVo> infoVos = JSONArray.parseArray(jedisUtil.hGet(enprNo, "UserInfoUid" + uid), UserInfoVo.class);
            return Result.success(infoVos);
        }
    }

    public ResultData getUserInfoByUname(String uname, String enprNo) {
        List<Integer> uids = userMapper.findUidsByUname(uname, enprNo);
        List<UserInfoVo> res = new ArrayList<>();
        for (int uid : uids) {
            res.addAll(userMapper.findUserInfoVoByUid(uid));
        }
        return Result.success(res);
    }

    public ResultData getUserInfoByMeterNo(String meterNo, int meterType, String enprNo) {
        int uid = -1;
        if (meterType == Constants.TYPE_WATERMETER) {
            uid = -1; //todo 组件间通信
        } else {
            uid = -1;
        }
        return Result.success(userMapper.findUserInfoVoByUid(uid));
    }
}
