package com.gm.statistical.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/26
 */
@Data
public class BaseRequest implements Serializable{

    private static final long serialVersionUID = 6916824330795970371L;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 设备号
     */
    private String deviceId;

    /**
     * 平台 0:安卓；1：IOS; 2: WEB; 3:小程序
     */
    private Integer platform;

    /**
     * 版本号
     */
    private Integer version;
}
