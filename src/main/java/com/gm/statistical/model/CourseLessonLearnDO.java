package com.gm.statistical.model;

import lombok.Builder;
import lombok.Data;

/**
 * @Description: 课程学习记录
 * @Author: zrk
 * @Date: 2019/12/11
 */
@Builder
@Data
public class CourseLessonLearnDO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户id(课程库)
     */
    private Long userId;

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
     * 学习开始时间
     */
    private Long startTime;

    /**
     * 学习结束时间
     */
    private Long finishedTime;

    /**
     * 学习时间
     */
    private Long learnTime;

    /**
     * 学习时间
     */
    private Long watchTime;

    /**
     * 观看次数
     */
    private Integer watchNum;

    /**
     * 视频状态(paused、playing)
     */
    private String videoStatus;

    /**
     * 视频类型
     */
    private String videoType;

    /**
     * 更新时间
     */
    private String updateTime;

}
