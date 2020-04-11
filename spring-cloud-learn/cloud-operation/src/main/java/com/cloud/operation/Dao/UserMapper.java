package com.cloud.operation.Dao;

import com.cloud.operation.Entity.User;
import com.cloud.operation.Entity.UserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/18 15:34
 */
@Repository
public interface UserMapper {
    List<User> findAllUsers(@Param("enprNo") String enprNo);

    List<User> findTotalUser();

    User findByUid(@Param("uid") int uid);

    int saveUser(User user);

    int delUserByUid(@Param("uid") int uid);

    int uptUser(User user);

    List<Integer> findUidsByBid(@Param("bId") int bId);

    List<UserInfoVo> findUserInfoVoByUid(int uid);

    List<Integer> findUidsByUname(@Param("uname") String uname, @Param("enprNo") String enprNo);

    User findByUnameAndTelAndEnprNo(@Param("uName") String uname, @Param("tel") String tel, @Param("enprNo") String enprNo);
}
