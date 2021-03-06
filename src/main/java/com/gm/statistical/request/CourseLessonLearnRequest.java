package com.gm.statistical.request;

import lombok.Data;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/11
 */
@Data
public class CourseLessonLearnRequest {
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
     * 学习结束时间
     */
    private Long finishedTime;

    /**
     * 学习时间
     */
    private Long learnTime;

    /**
     * 当前学习时间
     */
    private Long currentLearnTime;

    /**
     * 学习时间
     */
    private Long watchTime;

    /**
     * 观看次数
     */
    private Integer watchNum;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 视频类型(video:录播;live:直播;playBackH:欢拓回放;playBack:平台回放)
     */
    private String videoType;
}
