package com.cloud.files.Dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/19 14:50
 */
@Repository
public interface TxTestMapper {
    int save(@Param("txId") int txId);
}
