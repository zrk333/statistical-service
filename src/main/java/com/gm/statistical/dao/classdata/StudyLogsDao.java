package com.gm.statistical.dao.classdata;

import com.gm.statistical.model.StudyLogsDO;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/11
 */
public interface StudyLogsDao {

    /**
     * 添加观看视频记录信息
     * @param studyLogsDO
     */
    void addStudyLogs(StudyLogsDO studyLogsDO);
}
