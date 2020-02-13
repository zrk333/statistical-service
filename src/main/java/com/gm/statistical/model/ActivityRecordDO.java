package com.gm.statistical.model;

import lombok.Data;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
@Data
public class ActivityRecordDO {
    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 是否为新用户
     */
    private Integer isNew;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
