package com.gm.statistical.model;

import lombok.Data;

/**
 * @Description: 学习记录日志
 * @Author: zrk
 * @Date: 2019/12/11
 */
@Data
public class StudyLogsDO {

    /**
     * id
     */
    private Long id;

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
     * 手机唯一码
     */
    private String mId;

    /**
     * 课时类型(video、live)
     */
    private String type;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 平台
     */
    private String platform;
}
