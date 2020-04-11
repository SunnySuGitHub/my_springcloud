package com.cloud.files.Service;

import com.alibaba.fastjson.JSON;
import com.cloud.files.Dao.AmmeterMapper;
import com.cloud.files.Dao.UserMapper;
import com.cloud.files.Dao.WaterMeterMapper;
import com.cloud.files.Entity.User;
import com.cloud.files.utils.JedisUtil;
import com.cloud.files.utils.result.Result;
import com.cloud.files.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/18 15:43
 */
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    WaterMeterMapper waterMeterMapper;

    @Resource
    AmmeterMapper ammeterMapper;

    @Autowired
    JedisUtil jedisUtil;

    public ResultData findByUserId(int uid, String enprNo) {
        if (jedisUtil.hGet(enprNo, "Uid" + uid) == null) {
            User user = userMapper.findByUid(uid);
            jedisUtil.hSet(enprNo, "Uid" + uid, JSON.toJSONString(user));
            return Result.success(user);
        } else {
            User user = JSON.parseObject(jedisUtil.hGet(enprNo, "Uid" + uid), User.class);
            return Result.success(user);
        }
    }

    public ResultData delUserById(int uid, String enprNo) {
        jedisUtil.hDel(enprNo, "Uid" + uid);
        jedisUtil.hDel(enprNo, "UserInfoUid" + uid);
        return Result.success(userMapper.delUserByUid(uid));
    }

    public ResultData uptUser(User user) {
        String enprNo = user.getEnprNo();
        jedisUtil.hDel(enprNo, "Uid" + user.getuId());
        jedisUtil.hDel(enprNo, "UserInfoUid" + user.getuId());
        return Result.success(userMapper.uptUser(user));
    }

}
