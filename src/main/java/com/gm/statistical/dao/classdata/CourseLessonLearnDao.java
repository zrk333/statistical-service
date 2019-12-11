package com.gm.statistical.dao.classdata;

import com.gm.statistical.model.CourseLessonLearnDO;
import com.gm.statistical.request.CourseLessonLearnRequest;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/11
 */
public interface CourseLessonLearnDao {

    /**
     * 获取课程学习信息
     * @param courseLessonLearnRequest
     * @return
     */
    CourseLessonLearnDO getLearnInfoByCondition(@Param("request") CourseLessonLearnRequest courseLessonLearnRequest);

    /**
     * 添加课程学习信息
     * @param courseLessonLearnDO
     */
    void addLearnInfo(CourseLessonLearnDO courseLessonLearnDO);

    /**
     * 更新课程学习信息
     * @param courseLessonLearnRequest
     */
    void updateLearnInfo(CourseLessonLearnRequest courseLessonLearnRequest);
}
