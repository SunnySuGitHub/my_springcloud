package com.cloud.operation.Dao;

import com.cloud.operation.Entity.Enpr;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/20 14:59
 */
@Repository
public interface EnprMapper {
    Enpr findByEnprNo(String enprNo);
}
