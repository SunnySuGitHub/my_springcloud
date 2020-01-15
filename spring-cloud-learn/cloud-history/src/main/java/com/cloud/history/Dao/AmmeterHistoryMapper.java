package com.cloud.history.Dao;

import com.cloud.history.Entity.Ammeters.AmmeterHistorydata;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/23 19:49
 */
@Repository
public interface AmmeterHistoryMapper {
    List<AmmeterHistorydata> getAmmeterHistorydata(@Param("meterNo") String meterNo, @Param("enprNo") String enprNo, @Param("readType") int readType,
                                                   @Param("startLine") long startLine, @Param("endLine") long endLine);
}
