package com.gm.statistical.exception;

import com.gm.core.base.exception.GmCoreException;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/27
 */
public class InvalidUserIdException extends GmCoreException {

    public InvalidUserIdException() {
        super(Integer.valueOf(12001),"用户id不能为空");
    }
}
