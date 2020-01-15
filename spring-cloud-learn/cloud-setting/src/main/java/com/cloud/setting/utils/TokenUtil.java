package com.cloud.setting.utils;

import java.util.UUID;

/**
 * @author: suxinyu
 * @DateTme: 2019/12/14 16:47
 */
public class TokenUtil {
    public static String GetToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
