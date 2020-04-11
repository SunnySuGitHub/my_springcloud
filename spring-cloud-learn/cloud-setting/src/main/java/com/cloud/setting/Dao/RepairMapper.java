package com.cloud.setting.Dao;

import com.cloud.setting.Entity.Repair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/20 10:58
 */
public interface RepairMapper {
    int save(Repair repair);

    List<Repair> list(@Param("enprNo") String enprNo, @Param("state") int state);

    int uptRepair(Repair repair);
}
