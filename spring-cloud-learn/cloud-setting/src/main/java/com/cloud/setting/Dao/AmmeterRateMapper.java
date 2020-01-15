package com.cloud.setting.Dao;

import com.cloud.setting.Entity.AmmeterRate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/10 19:54
 */
@Repository
public interface AmmeterRateMapper {
    List<AmmeterRate> getRates(@Param("enprNo") String enprNo);
    List<AmmeterRate> getRateList(@Param("enprNo") String enprNo);
    int updateRate(AmmeterRate ammeterRate);
}
