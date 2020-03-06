package com.cloud.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:sping-cloud-learn
 * Created by Administrator on 2020/2/24
 */
@Service
public class TxService {
    @Transactional
    @LcnTransaction
    public String test() {
        int i = 1/0;
        return "OK";
    }
}
