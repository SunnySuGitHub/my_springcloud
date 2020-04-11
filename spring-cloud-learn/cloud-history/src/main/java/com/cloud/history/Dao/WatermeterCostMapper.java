package com.cloud.history.Dao;

import com.cloud.history.Entity.VO.MeterDailyCost;
import com.cloud.history.Entity.Watermeters.WatermeterCost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/25 15:45
 */
@Repository
public interface WatermeterCostMapper {
    List<MeterDailyCost> getWatermeterDailyCost(@Param("meterNo") String meterNo, @Param("enprNo") String enprNo);

    int save(WatermeterCost watermeterCost);
}
