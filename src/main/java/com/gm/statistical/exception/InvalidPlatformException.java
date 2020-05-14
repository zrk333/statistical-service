package com.gm.statistical.exception;

import com.gm.core.base.exception.GmCoreException;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/27
 */
public class InvalidPlatformException extends GmCoreException {

    public InvalidPlatformException() {
        super(Integer.valueOf(12000),"平台不能为空");
    }
}
