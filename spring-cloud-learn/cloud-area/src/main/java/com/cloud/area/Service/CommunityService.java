package com.cloud.area.Service;

import com.cloud.area.Dao.CommunityMapper;
import com.cloud.area.Entity.Community;
import com.cloud.area.utils.result.Result;
import com.cloud.area.utils.result.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/19 16:33
 */
@Service
public class CommunityService {

    @Resource
    CommunityMapper communityMapper;

    public ResultData getCommunity(int id) {
        return Result.success(communityMapper.getCommunity(id));
    }

    public ResultData addCommunity(Community community) {
        return Result.success(communityMapper.addCommunity(community));
    }

    public ResultData uptCommunity(Community community) {
        return Result.success(communityMapper.uptCommunity(community));
    }

    public ResultData delCommunity(int id) {
        return Result.success(communityMapper.delCommunity(id));
    }

    public ResultData communityList(String enprNo) {
        return Result.success(communityMapper.communityList(enprNo));
    }

}
