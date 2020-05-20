package com.gm.statistical.model;

import lombok.Data;

/**
 * @Description: 观看视频信息
 * @Author: zrk
 * @Date: 2019/12/10
 */
@Data
public class WatchVideoInfoDTO {

    /**
     * 用户id(课程库)
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 课程Id
     */
    private Long courseId;

    /**
     * 课时Id
     */
    private Long lessonId;

    /**
     * 学习状态(learning、finished)
     */
    private String status;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * 学习到课程的位置
     */
    private Long learnTime;

    /**
     * 课时类型
     */
    private String type;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 平台 0:安卓；1：IOS; 2: WEB; 3:小程序
     */
    private Integer platform;

    /**
     * 手机唯一码
     */
    private String mId;

    /**
     * 房间号
     */
    private String roomId;

}
