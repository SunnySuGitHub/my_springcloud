package com.cloud.device.Dao;

import com.cloud.device.Entity.Ammeter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/19 20:06
 */
@Repository
public interface AmmeterMapper {
    Ammeter getAmmeterDetail(@Param("ammeterNo") String ammeterNo, @Param("enprNo") String enprNo);

    List<Ammeter> getAllAmmeterDetail(@Param("enprNo") String enprNo, @Param("state") int state);

    List<Ammeter> findAll();

    int uptAmmeterValue(Ammeter ammeter);

    int delete(@Param("meterNo") String meterNo, @Param("enprNo") String enprNo);

    List<Ammeter> findFailedAmmeters(@Param("cid") int cid);

    List<Ammeter> findAmmeterByUid(@Param("uid") int uid);

    List<Ammeter> getAmmeterByCenter(@Param("centerId") int centerId);
}
