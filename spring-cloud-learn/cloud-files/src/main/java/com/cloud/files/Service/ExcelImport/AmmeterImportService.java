package com.cloud.files.Service.ExcelImport;

import com.cloud.files.Dao.TxTestMapper;
import com.cloud.files.utils.result.Result;
import com.cloud.files.utils.result.ResultData;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/19 11:05
 * 电表导入相关操作
 */
@Service
public class AmmeterImportService extends ImportBase {

    @Resource
    TxTestMapper testMapper;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResultData read(InputStream is, boolean isExcel2003, String enprNo, int communityId) {
        return null;
    }

    @Override
    public ResultData check(InputStream is, boolean isExcel2003, String enprNo, int communityId) {
        return null;
    }

    @LcnTransaction //分布式事务注解
    @Transactional //本地事务注解
    public ResultData test(int txId) throws Exception {
        String name = "suxinyu";
        System.out.println("come");
        int state = testMapper.save(txId);
        System.out.println(state);
        restTemplate.getForObject("http://CLOUD-CONSUMER/hello?name=" + name, String.class);
        return Result.success("1");
    }
}
