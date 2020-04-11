package com.cloud.device.Dao;

import com.cloud.device.Entity.Watermeter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/19 20:06
 */
@Repository
public interface WaterMeterMapper {
    Watermeter getWaterMeterDetail(@Param("meterNo") String meterNo, @Param("enprNo") String enprNo);

    List<Watermeter> getAllWaterMeterDetail(@Param("enprNo") String enprNo, @Param("state") int state);

    List<Watermeter> findAll();

    int uptWatermeterValue(Watermeter watermeter);

    int saveMeter(Watermeter watermeter);

    Set<String> findAllWatermeterNoByEnprNo(@Param("enprNo") String enprNo);

    List<Watermeter> findFailedWatermeter(int cid);

    List<Watermeter> findWatermeterByUid(@Param("uid") int uid);

    void monthlyRefresh();

    void dailyRefresh();

    int delete(@Param("meterNo") String meterNo, @Param("enprNo") String enprNo);

    List<Watermeter> getWatermeterByCenter(@Param("centerId") int centerId);
}
