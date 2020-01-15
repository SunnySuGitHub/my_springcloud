package com.cloud.setting.Dao;

import com.cloud.setting.Entity.Enpr;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/20 14:59
 */
@Repository
public interface EnprMapper {
    int addEnpr(Enpr enpr);
    List<Enpr> findAll();
    Enpr findByEnprNo(String enprNo);
    int uptByEnprNo(Enpr enpr);
}
