package com.gm.statistical.request;

import lombok.Data;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/13
 */
@Data
public class CenterRequest extends BaseRequest {

    /**
     * 用户id
     */
    private Long userId;
}
