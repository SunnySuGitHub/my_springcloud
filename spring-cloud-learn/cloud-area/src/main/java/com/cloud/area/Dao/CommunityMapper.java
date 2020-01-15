package com.cloud.area.Dao;

import com.cloud.area.Entity.Community;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/19 16:33
 */
@Repository
public interface CommunityMapper {

    int addCommunity(Community community);

    int delCommunity(@Param("cId") int id);

    Community getCommunity(@Param("cId") int id);

    int uptCommunity(Community community);

    List<Community> communityList(@Param("enprNo") String enprNo);

}
