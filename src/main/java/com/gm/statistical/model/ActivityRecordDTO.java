package com.gm.statistical.model;

import lombok.Data;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
@Data
public class ActivityRecordDTO {

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
}
