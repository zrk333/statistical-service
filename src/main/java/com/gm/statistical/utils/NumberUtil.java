package com.gm.statistical.utils;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/7/13
 */
public class NumberUtil {

    /**
     * 数字校验是否为空
     * @param num
     * @return 为空返回0，否则返回原值
     */
    public static Long checkNumberLong(Long num){
        return num == null ? 0 : num;
    }
}
